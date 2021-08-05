package me.hyanbp.ipet.api.pet;

import me.hyanbp.ipet.entity.Pet;
import me.hyanbp.ipet.service.pet.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetApi {

    private final PetService petService;

    public PetApi(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<Pet> create(@RequestBody PetRequest request) {
        Pet pet = petService.create(request);
        return ResponseEntity.ok(pet);
    }

    @GetMapping("/{id}/pet")
    public ResponseEntity<Pet> find(@PathVariable Long id) {
        Pet pet = petService.findById(id);
        return ResponseEntity.ok(pet);
    }


    @GetMapping("/{customerId}/customer")
    public ResponseEntity<List<Pet>> findByCustomerId(@PathVariable Long customerId) {
        List<Pet> pets = petService.findByCustomerId(customerId);
        return ResponseEntity.ok(pets);
    }

    @DeleteMapping("/{id}/pet")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        petService.deleteById(id);
        return ResponseEntity.ok("Pet removido com sucesso.");
    }

    @PatchMapping("{/id}/pet")
    public ResponseEntity<Pet> update(@PathVariable Long id, @RequestBody PetRequest request) {
        Pet pet = petService.update(id, request);
        return ResponseEntity.ok(pet);
    }
}

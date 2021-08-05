package me.hyanbp.ipet.service.pet;

import me.hyanbp.ipet.api.pet.PetRequest;
import me.hyanbp.ipet.entity.Customer;
import me.hyanbp.ipet.entity.Pet;
import me.hyanbp.ipet.repository.CustomerRepository;
import me.hyanbp.ipet.repository.PetRepository;
import me.hyanbp.ipet.service.customer.CustomerService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final CustomerService customerService;


    public PetService(PetRepository petRepository, CustomerService customerService) {
        this.petRepository = petRepository;
        this.customerService = customerService;
    }

    public Pet create(PetRequest request){
        Customer customer = customerService.findById(request.getCustomerId());
        return petRepository.save(new Pet(request.getName(), request.getBreed(), customer.getId()));
    }
    public Pet findById(Long id){
        Optional<Pet> pet = petRepository.findPetById(id);
        if(pet.isPresent()) return pet.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet não encontrado.");

    }

    public List<Pet> findByCustomerId(Long customerId){
        List<Pet> pets = petRepository.findAllPetByCustomerId(customerId);
        if(CollectionUtils.isNotEmpty(pets)) return pets;
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum pet encontrado para esse cliente.");
    }

    public void deleteById(Long id){
        Pet pet = findById(id);
        petRepository.delete(pet);
    }

    public Pet update(Long id, PetRequest request){
        Pet pet = findById(id);
        pet.setName(isBlank(request.getName()) ? pet.getName() : request.getName());
        pet.setBreed(isBlank(request.getBreed()) ? pet.getBreed() : request.getBreed());
        if(!isNull(request.getCustomerId())){
            Customer customer = customerService.findById(request.getCustomerId());
            pet.setCustomerId(customer.getId());
        }
        petRepository.save(pet);
        return pet;
    }


}

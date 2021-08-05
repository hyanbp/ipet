package me.hyanbp.ipet.repository;

import me.hyanbp.ipet.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, String> {


    Optional<Pet> findPetById(Long id);

    List<Pet> findAllPetByCustomerId(Long customerId);
}

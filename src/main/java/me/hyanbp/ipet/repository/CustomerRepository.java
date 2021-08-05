package me.hyanbp.ipet.repository;

import me.hyanbp.ipet.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    Optional<Customer> findCustomerByEmail(String email);
    Optional<Customer> findCustomerById(Long id);
}

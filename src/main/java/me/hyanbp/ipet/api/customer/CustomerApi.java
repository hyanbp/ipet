package me.hyanbp.ipet.api.customer;

import me.hyanbp.ipet.entity.Customer;
import me.hyanbp.ipet.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerApi {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/{id}/customer")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody CustomerRequest request) {
        String email = customerService.create(request);
        return ResponseEntity.ok(email);
    }


    @PatchMapping("/{id}/customer")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody CustomerRequest request) {
        Customer customer = customerService.update(id, request);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}/customer")
    public void delete(@PathVariable Long id) {
        customerService.delete(id);
    }

}

package me.hyanbp.ipet.service.customer;

import me.hyanbp.ipet.api.customer.CustomerRequest;
import me.hyanbp.ipet.entity.Customer;
import me.hyanbp.ipet.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public String create(CustomerRequest request){
        Optional<Customer> customer = customerRepository.findCustomerByEmail(request.getEmail());
        if (customer.isPresent()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email de cliente ja cadastrado.");
         return customerRepository.save(new Customer(request.getName(), request.getEmail(), request.getAge())).getEmail();
    }


    public Customer findById(Long id){
        Optional<Customer> customer = customerRepository.findCustomerById(id);
         if(customer.isPresent()) return customer.get();
         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado.");

    }

    public Customer update(Long id, CustomerRequest request) {
        Customer customer = findById(id);
        customer.setAge(request.getAge() == null ? customer.getAge() : request.getAge());
        customer.setEmail(isBlank(request.getEmail()) ? customer.getEmail() : request.getEmail());
        customer.setName(isBlank(request.getName())? customer.getEmail(): request.getEmail());
        customerRepository.save(customer);
        return customer;
    }

    public void delete(Long id){
        Customer customer = findById(id);
        customerRepository.delete(customer);
    }
}

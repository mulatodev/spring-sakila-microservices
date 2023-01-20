package com.arcadia.samples.sakila.customers.web;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.arcadia.samples.sakila.customers.model.Customer;
import com.arcadia.samples.sakila.customers.model.ICustomer;

/**
 *
 * @author ganaranjo
 */

@RestController
@Transactional
@RequestMapping("/api")
public class CustomerResource {
    
    @Autowired
    private ICustomer customerRepository;
    
    // CREATE Methods
    @PostMapping("/customer")
    public Customer registerCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }
    // End CREATE Methods

    // READ Methods
    @GetMapping("/customer/{id}")
    public List<Customer> getCustomer(@PathVariable Short id){        
        return customerRepository.findById(id);
    }

    @GetMapping("/customers")
    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }
    // End READ Methods

    // UPDATE Methods
    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable Short id, @RequestBody Customer customer){
        return customerRepository.saveAndFlush(customer);
    }
    // End UPDATE Methods

    // DELETE Methods
    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable Short id){
        customerRepository.deleteById(id);
    }
    // End DELETE Methods
}

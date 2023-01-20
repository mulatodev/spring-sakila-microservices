package com.arcadia.samples.sakila.customers.model;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ganaranjo
 */
public interface ICustomer extends JpaRepository<Customer, Long>{
    // CREATE Methods
    @Override
    Customer save(Customer customer);
    // End CREATE Methods

    // READ Methods
    @Override
    ArrayList<Customer> findAll();
    
    ArrayList<Customer> findById(@Param("id") Short id);
    // End READ Methods

    // UPDATE Methods
    @Override
    Customer saveAndFlush(Customer customer);
    // End UPDATE Methods

    // DELETE Methods
    void deleteById(@Param("id") Short id);
    // End DELETE Methods
}

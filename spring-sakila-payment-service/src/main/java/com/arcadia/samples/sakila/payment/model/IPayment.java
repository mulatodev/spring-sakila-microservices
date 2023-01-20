/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.arcadia.samples.sakila.payment.model;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ganaranjo
 */
public interface IPayment extends JpaRepository<Payment, Long>{
    // CREATE Methods
    @Override
    Payment save(Payment payment);
    // End CREATE Methods

    // READ Methods
    @Override
    ArrayList<Payment> findAll();
    
    ArrayList<Payment> findById(@Param("id") Short id);
    // End READ Methods

    // UPDATE Methods
    @Override
    Payment saveAndFlush(Payment payment);
    // End UPDATE Methods

    // DELETE Methods
    void deleteById(@Param("id") Short id);
    // End DELETE Methods
}

package com.arcadia.samples.sakila.customers.model;

import java.util.Date;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author ganaranjo
 * 
 */

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customer_id")
    private Short customer_id;
    
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    
    @Column(name = "first_name")
    private String first_name;
    
    @Column(name = "last_name")
    private String last_name;
    
    @Column(name = "email")
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    
    @Column(name = "active")
    private Byte active;
    
    @Column(name = "create_date")
    private Date create_date;
    
    @Column(name = "last_update")
    private Timestamp last_update;
    
    public Short getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Short customer_id) {
        this.customer_id = customer_id;
    }

    public Store getStore_id() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }
    
    
}

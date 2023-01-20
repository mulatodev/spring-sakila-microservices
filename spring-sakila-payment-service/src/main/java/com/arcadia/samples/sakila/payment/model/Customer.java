package com.arcadia.samples.sakila.payment.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;

/**
 *
 * @author ganaranjo
*/
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customer_id")
    private Short customerId;
    
    @Column(name = "store_id")
    private Byte storeId;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "address_id")
    private Short addressId;
    
    @Column(name = "actove")
    private Byte active;
    
    @Column(name = "create_date")
    private Date createDate;
    
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
    private Set<Payment> payments;
 
    public Short getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Short customerId) {
        this.customerId = customerId;
    }

    public Byte getStoreId() {
        return storeId;
    }

    public void setStoreId(Byte storeId) {
        this.storeId = storeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getAddressId() {
        return addressId;
    }

    public void setAddressId(Short addressId) {
        this.addressId = addressId;
    }

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
    protected Set<Payment> getPaymentsInternal(){
        if (this.payments == null) {
            this.payments = new HashSet<>();
        }
        return this.payments;
    }
    
    public List<Payment> getPayments(){
        final List<Payment> sortedPayments = new ArrayList<>(getPaymentsInternal());
        PropertyComparator.sort(sortedPayments, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedPayments);
    }
    
    public void addPayment(Payment payment){
        getPaymentsInternal().add(payment);
        payment.setCustomer(this);
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("customerId", this.getCustomerId())
            .append("storeId", this.getStoreId())
            .append("firstName", this.getFirstName())
            .append("lastName", this.getLastName())
            .append("email", this.getEmail())
            .append("addressId", this.getAddressId())
            .append("active", this.getActive())
            .append("createDate", this.getCreateDate())
            .append("lastUpdate", this.getLastUpdate())
            .toString();
    }
    
}

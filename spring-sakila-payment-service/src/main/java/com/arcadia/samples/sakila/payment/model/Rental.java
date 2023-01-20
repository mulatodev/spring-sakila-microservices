package com.arcadia.samples.sakila.payment.model;

import java.util.Date;
import java.sql.Timestamp;
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
@Table(name = "rental")
public class Rental {
    
    @Id
    @Column(name = "rental_id")
    private Integer rentalId;
    
    @Column(name = "rental_date")
    private Date rentalDate;
    
    @Column(name = "inventory_id")
    private Integer inventoryId;
    
    @Column(name = "customer_id")
    private Short customerId;
    
    @Column(name = "return_date")
    private Date returnDate;
    
    @Column(name = "staff_id")
    private Byte staffId;
    
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "rental")
    private Set<Payment> payments;
    
    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Short getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Short customerId) {
        this.customerId = customerId;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Byte getStaffId() {
        return staffId;
    }

    public void setStaffId(Byte staffId) {
        this.staffId = staffId;
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
        payment.setRental(this);
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("rentalId", this.getRentalId())
            .append("rentalDate", this.getRentalDate())
            .append("inventoryId", this.getInventoryId())
            .append("customerId", this.getCustomerId())
            .append("returnDate", this.getReturnDate())
            .append("staffId", this.getStaffId())
            .append("lastUpdate", this.getLastUpdate())
            .toString();
    }
    
}

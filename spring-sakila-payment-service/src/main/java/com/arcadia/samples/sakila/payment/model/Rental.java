package com.arcadia.samples.sakila.payment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import java.util.Date;
import java.sql.Timestamp;
import org.springframework.beans.support.PropertyComparator;

/**
 *
 * @author ganaranjo
 * SMALLINT --> Short
 * TINYINT --> Byte
 * VARCHAR --> String
 * DATETIME --> Java.util.Date
 * TIMESTAMP --> Java.sql.Timestamp
 */
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

    @OneToMany(cascade = CascadeType.ALL, fetch = fetchType.EAGER, mappedBy = "rental")
    private Set<Payment> payments
    
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
        final List<Payment> sortedPayments = new ArrayList<>(getInternalPets());
        PropertyComparator.sort(sortedPayments, new MutableSortedDefinition("name", true, true));
        return unmodifiableList(sortedPayments);
    }
    
    public void addPayment(Payment payment){
        getInternamPayments().add(payment);
        payment.setOwner(this);
    }
    
}

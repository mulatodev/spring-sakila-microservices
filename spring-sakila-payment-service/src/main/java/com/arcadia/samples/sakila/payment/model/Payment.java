package com.arcadia.samples.sakila.payment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.springframework.core.style.ToStringCreator;

/**
 *
 * @author ganaranjo
 */
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @Column(name = "payment_id")
    private Short paymentId;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
    
    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;
    
    @Column(name = "amount")
    private BigDecimal amount;
    
    @Column(name = "payment_date")
    private Date paymentDate;
    
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    
    public Short getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(final Short paymentId) {
        this.paymentId = paymentId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(final Staff staff) {
        this.staff = staff;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(final Rental rental) {
        this.rental = rental;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(final Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(final Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
    @Override
    public String toString(){
        return new ToStringCreator(this)
                .append("id", this.getPaymentId())
                .append("customerFirstName", this.customer.getFirstName())
                .append("customerLastName", this.customer.getLastName())
                .append("staffFirstName", this.staff.getFirstName())
                .append("staffLastName", this.staff.getLastName())
                .append("rentalDate", this.rental.getRentalDate())
                .append("amount", this.getAmount())
                .append("paymentDate", this.getPaymentDate())
                .append("lastUpdate", this.getLastUpdate())
                .toString();
    }
}

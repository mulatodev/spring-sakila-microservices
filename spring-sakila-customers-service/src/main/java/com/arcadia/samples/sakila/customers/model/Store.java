package com.arcadia.samples.sakila.customers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;

/**
 *
 * @author ganaranjo
*/
@Entity
@Table(name = "store")
public class Store {

    @Id
    @Column(name = "store_id")
    private Byte storeId;
    
    @Column(name = "manager_staff_id")
    private Byte managerStaffId;
    
    @Column(name = "address_id")
    private Short addressId;
    
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public Byte getStoreId() {
        return storeId;
    }

    public void setStoreId(Byte storeId) {
        this.storeId = storeId;
    }

    public Byte getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(Byte managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    public Short getAddressId() {
        return addressId;
    }

    public void setAddressId(Short addressId) {
        this.addressId = addressId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}

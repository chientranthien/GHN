package com.dalafarm.vendor.model;

import javax.validation.constraints.NotNull;

/**
 * Created by chien on 8/2/17.
 */
public class OrderSummary {

    private Integer vendorId;

    @NotNull
    private String pickupDistrictId;


    @NotNull
    private String dropDistrictId;

    //in gram
    private Integer weight;

    public OrderSummary() {

    }

    public OrderSummary(String pickupDistrictId, String dropDistrictId, Integer weight) {
        this.pickupDistrictId = pickupDistrictId;
        this.dropDistrictId = dropDistrictId;
        this.weight = weight;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getPickupDistrictId() {
        return pickupDistrictId;
    }

    public void setPickupDistrictId(String pickupDistrictId) {
        this.pickupDistrictId = pickupDistrictId;
    }

    public String getDropDistrictId() {
        return dropDistrictId;
    }

    public void setDropDistrictId(String dropDistrictId) {
        this.dropDistrictId = dropDistrictId;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}

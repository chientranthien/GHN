package com.dalafarm.vendor.model;

import javax.validation.constraints.NotNull;

/**
 * Created by chien on 8/2/17.
 */
public class OrderSummary {

    private Integer supplierId;

    @NotNull
    private String pickupDistrictId;


    @NotNull
    private String dropDistrictId;

    //in gram
    private Integer weight;

    public OrderSummary() {

    }


    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
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

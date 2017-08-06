package com.dalafarm.vendor.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 * Created by chien on 8/2/17.
 */
public class OrderDetail {

    @NotNull
    private String fromPerson;

    @NotNull
    private Integer cod;

    @NotNull
    private String pickupAddress;

    @NotNull
    private String pickupTel;

    @NotNull
    private String pickupDistrictId;

    @NotNull
    private String toPerson;

    @NotNull
    private String dropAddress;

    @NotNull
    private String dropTel;

    @NotNull
    private String dropDistrictId;

    private String dropEmail;

    private String note;

    @Column(name = "IS_FREESHIP")
    @JsonProperty("isFreeship")
    private boolean isFreeship;

    //Because Only 1 supplier in DB at this time(August 5 2017)
    private Integer supplierId = 1;

    private String dummyId;

    private String supplierOrderId;

    private Integer value;

    private Integer fee;

    private Integer insuranceFee;

    private String estimatedPickupTime;

    private String estimatedDeliverTime;

    public String getFromPerson() {
        return fromPerson;
    }

    public void setFromPerson(String fromPerson) {
        this.fromPerson = fromPerson;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }


    public String getPickupTel() {
        return pickupTel;
    }

    public void setPickupTel(String pickupTel) {
        this.pickupTel = pickupTel;
    }

    public String getToPerson() {
        return toPerson;
    }

    public void setToPerson(String toPerson) {
        this.toPerson = toPerson;
    }

    public String getDropAddress() {
        return dropAddress;
    }

    public void setDropAddress(String dropAddress) {
        this.dropAddress = dropAddress;
    }

    public String getDropTel() {
        return dropTel;
    }

    public void setDropTel(String dropTel) {
        this.dropTel = dropTel;
    }

    public String getDropEmail() {
        return dropEmail;
    }

    public void setDropEmail(String dropEmail) {
        this.dropEmail = dropEmail;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isFreeship() {
        return isFreeship;
    }

    public void setFreeship(boolean freeship) {
        isFreeship = freeship;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Integer getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(Integer insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public String getEstimatedPickupTime() {
        return estimatedPickupTime;
    }

    public void setEstimatedPickupTime(String estimatedPickupTime) {
        this.estimatedPickupTime = estimatedPickupTime;
    }

    public String getEstimatedDeliverTime() {
        return estimatedDeliverTime;
    }

    public void setEstimatedDeliverTime(String estimatedDeliverTime) {
        this.estimatedDeliverTime = estimatedDeliverTime;
    }

    public String getSupplierOrderId() {
        return supplierOrderId;
    }

    public void setSupplierOrderId(String supplierOrderId) {
        this.supplierOrderId = supplierOrderId;
    }

    public String getDummyId() {
        return dummyId;
    }

    public void setDummyId(String dummyId) {
        this.dummyId = dummyId;
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
}

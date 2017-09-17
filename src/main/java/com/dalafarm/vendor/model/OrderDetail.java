package com.dalafarm.vendor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 * Created by chien on 8/2/17.
 */
public class OrderDetail {

    @NotNull
    private String fromPerson;

    @NotNull
    private Integer grandTotal;

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
    private boolean isFreeship = true;

    @NotNull
    private Integer vendorId;

    @NotEmpty
    @Column(unique = true)
    private String orderId;

    private String vendorOrderId;

    private Integer value;

    private Integer shippingFee;

    private Integer insuranceFee;

    private String estimatedPickupTime;

    private String estimatedDeliverTime;

    private Integer statusId = 4;

    private Float weightInGram;

    public Float getWeightInGram() {
        return weightInGram;
    }

    public void setWeightInGram(Float weightInGram) {
        this.weightInGram = weightInGram;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getFromPerson() {
        return fromPerson;
    }

    public void setFromPerson(String fromPerson) {
        this.fromPerson = fromPerson;
    }

    public Integer getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Integer grandTotal) {
        this.grandTotal = grandTotal;
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

    public Integer getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Integer shippingFee) {
        this.shippingFee = shippingFee;
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

    public String getVendorOrderId() {
        return vendorOrderId;
    }

    public void setVendorOrderId(String vendorOrderId) {
        this.vendorOrderId = vendorOrderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
}

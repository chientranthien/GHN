package com.dalafarm.vendor.model.ghtk;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by chien on 8/4/17.w
 */
public class GhtkOrderDetail {
    @JsonProperty("pick_name")
    @NotNull
    private String fromPerson;

    @JsonProperty("pick_money")
    @NotNull
    private Integer pickupMoney;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @JsonProperty("value")
    @NotNull
    private Integer value;

    @JsonProperty("pick_address")
    @NotNull
    private String pickupAddress;

    @JsonProperty("pick_address_id")
    @NotNull
    private String pickupAddressId;

    public String getPickupAddressId() {
        return pickupAddressId;
    }

    public void setPickupAddressId(String pickupAddressId) {
        this.pickupAddressId = pickupAddressId;
    }

    @JsonProperty("pick_province")
    @NotNull
    private String pickupProvince;

    @JsonProperty("pick_district")
    @NotNull
    private String pickupDistrict;

    @JsonProperty("pick_ward")
    @NotNull
    private String pickupWard;

    public String getPickupWard() {
        return pickupWard;
    }

    public void setPickupWard(String pickupWard) {
        this.pickupWard = pickupWard;
    }

    @JsonProperty("pick_tel")
    @NotNull
    private String pickupTel;


    @JsonProperty("name")
    @NotNull
    private String toPerson;

    @JsonProperty("address")
    @NotNull
    private String dropAddress;

    @JsonProperty("province")
    @NotNull
    private String dropProvince;

    @JsonProperty("district")
    @NotNull
    private String dropDistrict;

    @JsonProperty("ward")
    @NotNull
    private String dropWard;

    @JsonProperty("tel")
    @NotNull
    private String dropTel;

    @JsonProperty("email")
    @NotNull
    private String dropEmail;

    public Integer getIsFreeship() {
        return isFreeship;
    }

    public void setIsFreeship(Integer isFreeship) {
        this.isFreeship = isFreeship;
    }

    public void setIsFreeship(boolean isFreeship) {
        if(isFreeship){
            this.isFreeship = 1;
        } else {
            this.isFreeship = 0;
        }
    }

    @JsonProperty("is_freeship")
    private Integer isFreeship;

    private String note;

    private String id;

    public String getFromPerson() {
        return fromPerson;
    }

    public void setFromPerson(String fromPerson) {
        this.fromPerson = fromPerson;
    }

    public Integer getPickupMoney() {
        return pickupMoney;
    }

    public void setPickupMoney(Integer pickupMoney) {
        this.pickupMoney = pickupMoney;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getPickupProvince() {
        return pickupProvince;
    }

    public void setPickupProvince(String pickupProvince) {
        this.pickupProvince = pickupProvince;
    }

    public String getPickupDistrict() {
        return pickupDistrict;
    }

    public void setPickupDistrict(String pickupDistrict) {
        this.pickupDistrict = pickupDistrict;
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

    public String getDropProvince() {
        return dropProvince;
    }

    public void setDropProvince(String dropProvince) {
        this.dropProvince = dropProvince;
    }

    public String getDropDistrict() {
        return dropDistrict;
    }

    public void setDropDistrict(String dropDistrict) {
        this.dropDistrict = dropDistrict;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDropWard() {
        return dropWard;
    }

    public void setDropWard(String dropWard) {
        this.dropWard = dropWard;
    }
}

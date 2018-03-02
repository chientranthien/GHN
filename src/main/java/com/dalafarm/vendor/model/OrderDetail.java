package com.dalafarm.vendor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 * Created by chien on 8/2/17.
 */
@Data
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
    private String dropDistrict;

    @NotNull
    private String dropDistrictId;

    @NotNull
    private String dropWardId;

    @NotNull
    private String dropWard;

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

}

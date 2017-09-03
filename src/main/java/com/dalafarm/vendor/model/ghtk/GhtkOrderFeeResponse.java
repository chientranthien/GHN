package com.dalafarm.vendor.model.ghtk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by chien on 8/4/17.
 */
public class GhtkOrderFeeResponse {
    @JsonProperty("success")
    private boolean success;

    @JsonProperty("message")
    private String message;

    @JsonProperty("shippingFee")
    private OrderFeeDetail orderFeeDetail;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public OrderFeeDetail getOrderFeeDetail() {
        return orderFeeDetail;
    }

    public void setOrderFeeDetail(OrderFeeDetail orderFeeDetail) {
        this.orderFeeDetail = orderFeeDetail;
    }

    @JsonIgnore
    public String getServiceName() {
        return getOrderFeeDetail().getServiceName();
    }

    public void setServiceName(String serviceName) {
        getOrderFeeDetail().setServiceName(serviceName);
    }

    @JsonIgnore
    public Integer getShippingFee() {
        return getOrderFeeDetail().getShippingFee();
    }

    public void setShippingFee(Integer shippingFee) {
        getOrderFeeDetail().setShippingFee(shippingFee);
    }

    @JsonIgnore
    public Integer getInsuranceFee() {
        return getOrderFeeDetail().getInsuranceFee();
    }

    public void setInsuranceFee(Integer insuranceFee) {
        getOrderFeeDetail().setInsuranceFee(insuranceFee);
    }

    @JsonIgnore
    public String getDeliveryType() {
        return getOrderFeeDetail().getDeliveryType();
    }

    public void setDeliveryType(String deliveryType) {
        getOrderFeeDetail().setDeliveryType(deliveryType);
    }

    @JsonIgnore
    public boolean isDeliverable() {
        return getOrderFeeDetail().isDeliverable();
    }

    public void setDeliverable(boolean deliverable) {
        getOrderFeeDetail().setDeliverable(deliverable);
    }

    private static class OrderFeeDetail {
        @JsonProperty("name")
        String serviceName;

        @JsonProperty("shippingFee")
        Integer shippingFee;

        @JsonProperty("insurance_fee")
        Integer insuranceFee;


        @JsonProperty("delivery_type")
        String deliveryType;

        @JsonProperty("delivery")
        boolean deliverable;

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
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

        public String getDeliveryType() {
            return deliveryType;
        }

        public void setDeliveryType(String deliveryType) {
            this.deliveryType = deliveryType;
        }

        public boolean isDeliverable() {
            return deliverable;
        }

        public void setDeliverable(boolean deliverable) {
            this.deliverable = deliverable;
        }
    }
}

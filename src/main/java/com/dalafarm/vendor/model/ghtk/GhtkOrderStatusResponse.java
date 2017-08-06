package com.dalafarm.vendor.model.ghtk;

import com.dalafarm.vendor.model.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by chien on 8/5/17.
 */
public class GhtkOrderStatusResponse {
    private Boolean success;
    private String message;

    @JsonProperty("order")
    private Order order;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonIgnore
    public String getSupplierOrderId() {
        return order.getSupplierOrderId();
    }

    public void setSupplierOrderId(String supplierOrderId) {
        order.setSupplierOrderId(supplierOrderId);
    }

    @JsonIgnore
    public String getDummyOrderId() {
        return order.getDummyOrderId();
    }

    public void setDummyOrderId(String dummyOrderId) {
        order.setDummyOrderId(dummyOrderId);
    }

    @JsonIgnore
    public Integer getStatus() {
        return order.getStatus();
    }

    public void setStatus(Integer status) {
        order.setStatus(status);
    }

    @JsonIgnore
    public String getCreatedDate() {
        return order.getCreatedDate();
    }

    public void setCreatedDate(String createdDate) {
        order.setCreatedDate(createdDate);
    }

    @JsonIgnore
    public String getUpdatedDate() {
        return order.getUpdatedDate();
    }

    public void setUpdatedDate(String updatedDate) {
        order.setUpdatedDate(updatedDate);
    }

    @JsonIgnore
    public String getPickupDate() {
        return order.getPickupDate();
    }

    public void setPickupDate(String pickupDate) {
        order.setPickupDate(pickupDate);
    }

    @JsonIgnore
    public String getPickupPeriod() {
        return order.getPickupPeriod();
    }

    public void setPickupPeriod(String pickupPeriod) {
        order.setPickupPeriod(pickupPeriod);
    }

    @JsonIgnore
    public String getDeliveryDate() {
        return order.getDeliveryDate();
    }

    public void setDeliveryDate(String deliveryDate) {
        order.setDeliveryDate(deliveryDate);
    }

    @JsonIgnore
    public String getDeliveryPeriod() {
        return order.getDeliveryPeriod();
    }

    public void setDeliveryPeriod(String deliveryPeriod) {
        order.setDeliveryPeriod(deliveryPeriod);
    }

    private static class Order {
        @JsonProperty("label_id")
        private String supplierOrderId;

        @JsonProperty("partner_id")
        private String dummyOrderId;

        @JsonProperty("status")
        private Integer status;

        @JsonProperty("created")
        private String createdDate;

        @JsonProperty("updated")
        private String updatedDate;

        @JsonProperty("pick_date")
        private String pickupDate;

        @JsonProperty("pick_period")
        private String pickupPeriod;

        @JsonProperty("deliver_date")
        private String deliveryDate;

        @JsonProperty("deliver_period")
        private String deliveryPeriod;

        public String getSupplierOrderId() {
            return supplierOrderId;
        }

        public void setSupplierOrderId(String supplierOrderId) {
            this.supplierOrderId = supplierOrderId;
        }

        public String getDummyOrderId() {
            return dummyOrderId;
        }

        public void setDummyOrderId(String dummyOrderId) {
            this.dummyOrderId = dummyOrderId;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public String getUpdatedDate() {
            return updatedDate;
        }

        public void setUpdatedDate(String updatedDate) {
            this.updatedDate = updatedDate;
        }

        public String getPickupDate() {
            return pickupDate;
        }

        public void setPickupDate(String pickupDate) {
            this.pickupDate = pickupDate;
        }

        public String getPickupPeriod() {
            return pickupPeriod;
        }

        public void setPickupPeriod(String pickupPeriod) {
            this.pickupPeriod = pickupPeriod;
        }

        public String getDeliveryDate() {
            return deliveryDate;
        }

        public void setDeliveryDate(String deliveryDate) {
            this.deliveryDate = deliveryDate;
        }

        public String getDeliveryPeriod() {
            return deliveryPeriod;
        }

        public void setDeliveryPeriod(String deliveryPeriod) {
            this.deliveryPeriod = deliveryPeriod;
        }
    }
}

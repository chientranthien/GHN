package com.example.ghn.model;

/**
 * Created by chien on 8/4/17.
 */
public class OrderResponse {
    private boolean success;

    private int totalFee;

    private String supplierOrderId;

    private String supplierOrderMessage;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public String getSupplierOrderId() {
        return supplierOrderId;
    }

    public void setSupplierOrderId(String supplierOrderId) {
        this.supplierOrderId = supplierOrderId;
    }

    public String getSupplierOrderMessage() {
        return supplierOrderMessage;
    }

    public void setSupplierOrderMessage(String supplierOrderMessage) {
        this.supplierOrderMessage = supplierOrderMessage;
    }
}

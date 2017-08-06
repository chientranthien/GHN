package com.dalafarm.vendor.model;

/**
 * Created by chien on 8/4/17.
 */
public class OrderFeeResponse {
    private boolean success;

    private String message;

    private int totalFee;


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

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }
}

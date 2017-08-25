package com.dalafarm.vendor.model;

/**
 * Created by chien on 8/4/17.
 */
public class OrderFeeResponse extends Response {


    private int totalFee;

    private int vendorId;


    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }
}

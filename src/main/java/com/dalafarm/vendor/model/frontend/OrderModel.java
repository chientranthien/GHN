package com.dalafarm.vendor.model.frontend;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Map;

/**
 * This object is used to receive data from website
 * Created by LeeU on 9/3/2017.
 */
public class OrderModel {
    @NotEmpty
    @JsonProperty("id")
    private String orderId;

    private Map<String, Integer> promotionalProducts;

    private String status;

    private String shippingCost;

    private Integer shippingVendor;

    private Integer subtotal;

    @JsonProperty("products")
    private ProductModel[] productModels;

    private String promoCode;

    private Meta meta;

    private Info info;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Map<String, Integer> getPromotionalProducts() {
        return promotionalProducts;
    }

    public void setPromotionalProducts(Map<String, Integer> promotionalProducts) {
        this.promotionalProducts = promotionalProducts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(String shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Integer getShippingVendor() {
        return shippingVendor;
    }

    public void setShippingVendor(Integer shippingVendor) {
        this.shippingVendor = shippingVendor;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    public ProductModel[] getProductModels() {
        return productModels;
    }

    public void setProductModels(ProductModel[] productModels) {
        this.productModels = productModels;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "ClassPojo [orderId = " + orderId + ", promotionalProducts = " + promotionalProducts + ", status = " + status + ", shippingCost = " + shippingCost + ", shippingVendor = " + shippingVendor + ", subtotal = " + subtotal + ", productModels = " + productModels + ", promoCode = " + promoCode + ", meta = " + meta + ", info = " + info + "]";
    }
}
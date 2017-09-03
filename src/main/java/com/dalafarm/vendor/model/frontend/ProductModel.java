package com.dalafarm.vendor.model.frontend;

/**
 * Created by LeeU on 9/3/2017.
 */
public class ProductModel {
    private Integer amount;

    private String price;

    private String name;

    private Integer subtotal;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "ClassPojo [amount = " + amount + ", price = " + price + ", name = " + name + ", subtotal = " + subtotal + "]";
    }
}

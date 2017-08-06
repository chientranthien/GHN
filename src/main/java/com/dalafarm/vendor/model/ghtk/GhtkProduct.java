package com.example.ghn.model.ghtk;

/**
 * Created by chien on 8/5/17.
 */
public class GhtkProduct {

    private String name;

    private int price;

    //in kilogram
    private float weight;

    private int quantity;

    public GhtkProduct(String name, int price, float weight, int quantity) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

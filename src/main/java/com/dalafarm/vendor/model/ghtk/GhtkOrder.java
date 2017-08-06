package com.dalafarm.vendor.model.ghtk;

import com.dalafarm.vendor.model.OrderDetail;
import com.dalafarm.vendor.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Embedded;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by chien on 8/4/17.
 */
public class GhtkOrder {
    @JsonProperty("products")
    private List<GhtkProduct> products;

    @NotNull
    @JsonProperty("order")
    private GhtkOrderDetail orderDetail;


    public List<GhtkProduct> getProducts() {
        return products;
    }

    public void setProducts(List<GhtkProduct> products) {
        this.products = products;
    }

    public GhtkOrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(GhtkOrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }
}

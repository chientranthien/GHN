package com.dalafarm.vendor.model;

import lombok.Data;

/**
 * Created by chien on 8/5/17.
 */
@Data
public class OrderStatusResponse extends Response{

    private String orderId;

    private String name;

    private String lastUpdatedDate;

    private String estimatedDeliveryTime;
}

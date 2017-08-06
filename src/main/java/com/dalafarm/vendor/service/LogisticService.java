package com.dalafarm.vendor.service;


import com.dalafarm.vendor.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Created by chien on 8/1/17.
 */
public interface LogisticService {
    OrderFeeResponse calculateServiceFee(OrderSummary orderSummary);

    OrderResponse order(Order order)  ;

    OrderStatusResponse getOrderStatus(String supplierOrderId);
}

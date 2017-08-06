package com.dalafarm.vendor.controller;

import com.dalafarm.vendor.model.*;
import com.dalafarm.vendor.repository.OrderRepository;
import com.dalafarm.vendor.service.LogisticService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by chien on 7/29/17.
 */
@RestController
@RequestMapping("v1/orders")
public class GhtkController {


    @Autowired
    LogisticService ghtkService;

    @Autowired
    OrderRepository orderRepository;


    @RequestMapping(value = "fee", method = RequestMethod.POST)
    public OrderFeeResponse calculateServiceFee(@RequestBody @Valid OrderSummary orderSummary) {
        return ghtkService.calculateServiceFee(orderSummary);
    }

    @RequestMapping("/{id}")
    public Object getOrder(@PathVariable("id") Long id) {

        return "getOrder";

    }

    @RequestMapping(value = "/{supplierOrderId}/status", method = RequestMethod.GET)
    public OrderStatusResponse getOrderStatus(@PathVariable("supplierOrderId") String supplierOrderId) {

        return ghtkService.getOrderStatus(supplierOrderId);

    }

    @RequestMapping(method = RequestMethod.GET)
    public Object getAllOrder() {
        return orderRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public OrderResponse order(@RequestBody @Valid  Order order) {
        return ghtkService.order(order);
    }

}

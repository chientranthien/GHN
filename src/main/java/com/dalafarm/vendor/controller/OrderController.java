package com.dalafarm.vendor.controller;

import com.dalafarm.vendor.model.Order;
import com.dalafarm.vendor.model.OrderResponse;
import com.dalafarm.vendor.model.OrderStatusResponse;
import com.dalafarm.vendor.model.Response;
import com.dalafarm.vendor.repository.OrderRepository;
import com.dalafarm.vendor.service.LogisticService;
import com.dalafarm.vendor.util.LogisticServiceFactory;
import com.dalafarm.vendor.util.VendorId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Vu on 8/13/2017.
 */
@RestController
@RequestMapping("v1")
public class OrderController {


    @Autowired
    OrderRepository orderRepository;

    @Autowired
    LogisticServiceFactory logisticServiceFactory;

    @RequestMapping("order/{id}")
    public Object getOrder(@PathVariable("id") Long id) {
        return orderRepository.findOne(id);
    }

    @RequestMapping(value = "order/{id}/status", method = RequestMethod.GET)
    public OrderStatusResponse getOrderStatus(@PathVariable("id") String orderId) {
        //currently hard coding to giao hang tiet kiem
        LogisticService logisticService = logisticServiceFactory.getLogisticService(VendorId.GHTK);
        return logisticService.getOrderStatus(orderId);
    }

    @RequestMapping(value = "order/{id}/activate", method = RequestMethod.GET)
    public Response activateOrder(@PathVariable("id") Long orderId) {

        Order order = orderRepository.findOne(orderId);
        LogisticService logisticService = logisticServiceFactory.getLogisticService(order.getOrderDetail().getVendorId());
        return logisticService.activateOrder(order);
    }

    @RequestMapping(value = "orders", method = RequestMethod.GET)
    public Object getAllOrders() {
        return orderRepository.findAll();
    }

    @RequestMapping(value = "order", method = RequestMethod.POST)
    public OrderResponse order(@RequestBody @Valid Order order) {
        //currently hard coding to giao hang tiet kiem
        LogisticService logisticService = logisticServiceFactory.getLogisticService(VendorId.GHTK);
        return logisticService.createOrder(order);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Order not found")
    public void notFoundExceptionHandler(ResourceNotFoundException ex) {
    }
}

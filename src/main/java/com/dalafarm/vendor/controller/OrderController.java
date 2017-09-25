package com.dalafarm.vendor.controller;

import com.dalafarm.vendor.model.*;
import com.dalafarm.vendor.model.frontend.OrderModel;
import com.dalafarm.vendor.repository.OrderRepository;
import com.dalafarm.vendor.service.LogisticService;
import com.dalafarm.vendor.service.OrderModelMapper;
import com.dalafarm.vendor.service.OrderService;
import com.dalafarm.vendor.service.StatusMapper;
import com.dalafarm.vendor.util.LogisticServiceFactory;
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

    @Autowired
    OrderModelMapper orderModelMapper;

    @Autowired
    OrderService orderService;

    @Autowired
    StatusMapper statusMapper;

    @RequestMapping("order/{orderId}")
    public Object getOrder(@PathVariable("orderId") String orderId) {
        return orderRepository.findByOrderDetailOrderId(orderId);
    }

    @RequestMapping(value = "order/{orderId}/status", method = RequestMethod.GET)
    public OrderStatusResponse getOrderStatus(@PathVariable("orderId") String orderId) {
        Order order = orderRepository.findByOrderDetailOrderId(orderId);
        OrderStatusResponse orderStatusResponse = new OrderStatusResponse();
        orderStatusResponse.setOrderId(orderId);
        orderStatusResponse.setName(statusMapper.getHumanReadableStatus(order.getOrderDetail().getStatusId()));
        orderStatusResponse.setLastUpdatedDate(order.getLastModifiedDate().toString());
        orderStatusResponse.setEstimatedDeliveryTime(order.getOrderDetail().getEstimatedDeliverTime());
        return orderStatusResponse;
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
    public OrderResponse order(@RequestBody @Valid OrderModel orderModel) {
        Order order = orderModelMapper.toOrder(orderModel);
        LogisticService logisticService = getLogisticServiceBasedOnOrder(order);
        return logisticService.createOrder(order);
    }

    @PutMapping(value = "order")
    public void updateOrderStatus(@RequestBody @Valid OrderStatusRequest orderStatusRequest){
        orderService.updateOrderStatus(orderStatusRequest);
    }

    private LogisticService getLogisticServiceBasedOnOrder(@RequestBody @Valid Order order) {
        LogisticService logisticService;
        if(order.getOrderDetail().getVendorId() == null){
            logisticService = logisticServiceFactory.getDefaultLogisticService();
        }else{
            logisticService = logisticServiceFactory.getLogisticService(order.getOrderDetail().getVendorId());
        }
        return logisticService;
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Order not found")
    public void notFoundExceptionHandler(ResourceNotFoundException ex) {
    }
}

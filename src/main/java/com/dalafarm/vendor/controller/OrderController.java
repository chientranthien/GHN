package com.dalafarm.vendor.controller;

import com.dalafarm.vendor.model.*;
import com.dalafarm.vendor.model.frontend.OrderModel;
import com.dalafarm.vendor.repository.OrderRepository;
import com.dalafarm.vendor.service.LogisticService;
import com.dalafarm.vendor.service.OrderModelMapper;
import com.dalafarm.vendor.service.OrderService;
import com.dalafarm.vendor.service.StatusMapper;
import com.dalafarm.vendor.util.LogisticServiceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Vu on 8/13/2017.
 */
@RestController
@RequestMapping("v1")
@Slf4j
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

    @PostMapping(value = "queue/order-status", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void storeOrderStatus(@RequestBody MultiValueMap<String, String> object){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssX");
        OrderStatusRequest request = new OrderStatusRequest();
        request.setOrderId(object.getFirst("partner_id"));
        request.setVendorOrderId(object.getFirst("label_id"));
        request.setStatusId(Integer.parseInt(object.getFirst("status_id")));
        try {
            request.setActionTime(dateFormat.parse(object.getFirst("action_time")));
        } catch (ParseException e) {
            log.error("Unparseable action_time", e);
        }
        request.setReasonCode(object.getFirst("reason_code"));
        request.setReason(object.getFirst("reason"));
        request.setWeight(Float.parseFloat(object.getFirst("weight")));
        request.setShippingFee(Integer.parseInt(object.getFirst("fee")));
        log.info("Order status received: {}", request.toString());
        orderService.updateOrderStatus(request);
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

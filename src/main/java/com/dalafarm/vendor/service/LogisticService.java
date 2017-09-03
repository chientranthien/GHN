package com.dalafarm.vendor.service;


import com.dalafarm.vendor.controller.StatusController;
import com.dalafarm.vendor.model.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * Created by chien on 8/1/17.
 */
public interface LogisticService {


    OrderFeeResponse calculateServiceFee(OrderSummary orderSummary);

    OrderResponse createOrder(Order order);

    OrderStatusResponse getOrderStatus(String supplierOrderId);

    Response activateOrder(Order order);

    default Response activateOrder(Order order, Consumer<Order> onActive) {
        final Integer ACTIVE_CODE = 6;
        final Integer INACTIVE_CODE = 5;

        final String SUCCESS_MESSAGE = "The Order was activated and forwarded to the vendor";
        final String FAILED_MESSAGE = "This Order had been activated already";

        OrderDetail orderDetail = order.getOrderDetail();
        Response response = new Response();
        if (Objects.equals(orderDetail.getStatusId(), INACTIVE_CODE)) {
            orderDetail.setStatusId(ACTIVE_CODE);
            onActive.accept(order);
            response.setSuccess(true);
            response.setMessage(SUCCESS_MESSAGE);

        } else if (orderDetail.getStatusId() >= ACTIVE_CODE) {
            response.setSuccess(false);
            response.setMessage(FAILED_MESSAGE);
        }
        Link statusLink = ControllerLinkBuilder.linkTo(StatusController.class).slash(orderDetail.getStatusId()).withRel("status");

        Link allStatusLink = ControllerLinkBuilder.linkTo(StatusController.class).withRel("allStatuses");

        response.add(statusLink, allStatusLink);
        return response;
    }
}

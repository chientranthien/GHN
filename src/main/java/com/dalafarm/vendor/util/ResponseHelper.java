package com.dalafarm.vendor.util;

import com.dalafarm.vendor.controller.ResourceNotFoundException;
import com.dalafarm.vendor.model.*;
import com.dalafarm.vendor.model.ghtk.GhtkOrderFeeResponse;
import com.dalafarm.vendor.model.ghtk.GhtkOrderResponse;
import com.dalafarm.vendor.model.ghtk.GhtkOrderStatusResponse;
import com.dalafarm.vendor.repository.StatusRepository;

/**
 * Created by chien on 8/4/17.
 */
public class ResponseHelper {
    public static OrderResponse buildOrderResponse(GhtkOrderResponse ghtkOrderResponse) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setSuccess(ghtkOrderResponse.isSuccess());
        orderResponse.setSupplierOrderMessage(ghtkOrderResponse.getMessage());
        orderResponse.setTotalFee(Integer.parseInt(ghtkOrderResponse.getFee()));
        orderResponse.setSupplierOrderId(ghtkOrderResponse.getSupplierOrderId());
        return orderResponse;
    }

    public static OrderFeeResponse buildOrderFeeResponse(GhtkOrderFeeResponse ghtkOrderFeeResponse) {
        OrderFeeResponse orderFeeResponse = new OrderFeeResponse();
        orderFeeResponse.setSuccess(ghtkOrderFeeResponse.isSuccess());
        orderFeeResponse.setMessage(ghtkOrderFeeResponse.getMessage());
        orderFeeResponse.setTotalFee(ghtkOrderFeeResponse.getFee());

        return orderFeeResponse;
    }


    public static Order insertSupplierOrderResponseIntoOrder(GhtkOrderResponse body, Order order) {

        if (!body.isSuccess())
            return null;
        OrderDetail orderDetail = order.getOrderDetail();
        orderDetail.setFee(Integer.valueOf(body.getFee()));
        orderDetail.setEstimatedDeliverTime(body.getEstimatedDeliverTime());
        orderDetail.setEstimatedPickupTime(body.getEstimatedPickUtime());
        orderDetail.setInsuranceFee(Integer.valueOf(body.getInsuranceFee()));
        orderDetail.setSupplierOrderId(body.getSupplierOrderId());
        return order;
    }

    public static OrderStatusResponse buildOrderStatusResponse(GhtkOrderStatusResponse ghtkOrderStatusResponse) {
        if (ghtkOrderStatusResponse.isSuccess()) {
            OrderStatusResponse response = new OrderStatusResponse();
            response.setName(response.getName());
            response.setLastUpdatedDate(ghtkOrderStatusResponse.getUpdatedDate());
            return response;
        }
        throw new ResourceNotFoundException("Order", ghtkOrderStatusResponse.getMessage());
    }
}

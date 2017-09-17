package com.dalafarm.vendor.util;

import com.dalafarm.vendor.controller.ResourceNotFoundException;
import com.dalafarm.vendor.model.*;
import com.dalafarm.vendor.model.ghtk.GhtkOrderFeeResponse;
import com.dalafarm.vendor.model.ghtk.GhtkOrderResponse;
import com.dalafarm.vendor.model.ghtk.GhtkOrderStatusResponse;

/**
 * Created by chien on 8/4/17.
 */
public class ResponseHelper {
    public static OrderResponse buildOrderResponse(Order order) {
        final String SUCCESSFUL_MESSAGE = "The order was created successfully";
        final String FAILED_MESSAGE = "Failure to create order";

        OrderResponse response = new OrderResponse();

        if (order != null) {
            response.setSuccess(true);
            response.setMessage(SUCCESSFUL_MESSAGE);
            Integer vendorId = order.getOrderDetail().getVendorId();
            response.setVendorId(vendorId);
        } else {
            response.setSuccess(false);
            response.setMessage(FAILED_MESSAGE);
        }
        return response;
    }

    public static OrderFeeResponse buildOrderFeeResponse(GhtkOrderFeeResponse ghtkOrderFeeResponse) {
        final String SUCCESSFUL_MESSAGE = "Able to deliver this package";
        final String FAILED_MESSAGE = "Unable to deliver, probably the vendor doesn't support pickup/drop location yet";
        final int VENDOR_ID = 1;

        OrderFeeResponse orderFeeResponse = new OrderFeeResponse();
        orderFeeResponse.setSuccess(ghtkOrderFeeResponse.isSuccess());
        orderFeeResponse.setMessage(SUCCESSFUL_MESSAGE);
        orderFeeResponse.setTotalFee(ghtkOrderFeeResponse.getShippingFee());
        orderFeeResponse.setVendorId(VENDOR_ID);
        return orderFeeResponse;
    }


    public static Order insertVendorOrderResponseIntoOrder(GhtkOrderResponse ghtkOrderResponse, Order order) {

        if (!ghtkOrderResponse.isSuccess())
            return null;
        OrderDetail orderDetail = order.getOrderDetail();
        orderDetail.setShippingFee(Integer.valueOf(ghtkOrderResponse.getShippingFee()));
        orderDetail.setEstimatedDeliverTime(ghtkOrderResponse.getEstimatedDeliverTime());
        orderDetail.setEstimatedPickupTime(ghtkOrderResponse.getEstimatedPickUtime());
        orderDetail.setInsuranceFee(Integer.valueOf(ghtkOrderResponse.getInsuranceFee()));
        orderDetail.setVendorOrderId(ghtkOrderResponse.getSupplierOrderId());
        orderDetail.setInsuranceFee(Integer.valueOf(ghtkOrderResponse.getInsuranceFee()));
        orderDetail.setStatusId(5);
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

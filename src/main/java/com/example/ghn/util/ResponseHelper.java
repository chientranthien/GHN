package com.example.ghn.util;

import com.example.ghn.model.*;
import com.example.ghn.model.ghtk.GhtkOrderFeeResponse;
import com.example.ghn.model.ghtk.GhtkOrderResponse;
import com.example.ghn.model.ghtk.GhtkOrderStatusResponse;
import com.example.ghn.repository.StatusRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

    public static OrderStatusResponse buildOerderStatusResponse(StatusRepository repository, GhtkOrderStatusResponse ghtkOrderStatusResponse) {
        Status status = repository.findByGhtkStatusId(ghtkOrderStatusResponse.getStatus());
        OrderStatusResponse response = new OrderStatusResponse();
        response.setId(status.getId());
        response.setName(status.getName());
        response.setLastUpdatedDate(ghtkOrderStatusResponse.getUpdatedDate());
        return response;
    }
}

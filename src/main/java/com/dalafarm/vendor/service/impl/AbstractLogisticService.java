package com.dalafarm.vendor.service.impl;

import com.dalafarm.vendor.model.Order;
import com.dalafarm.vendor.model.OrderProduct;
import com.dalafarm.vendor.model.OrderResponse;
import com.dalafarm.vendor.repository.OrderRepository;
import com.dalafarm.vendor.service.LogisticService;
import com.dalafarm.vendor.util.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by LeeU on 9/3/2017.
 */
public abstract class AbstractLogisticService implements LogisticService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderResponse createOrder(Order order) {
        Order existingOrder = orderRepository.findByOrderDetailOrderId(order.getOrderDetail().getOrderId());
        if(existingOrder != null){
            order = updateOrder(existingOrder, order);
        }else{
            order.setCreatedDate(new Date());
            order.setLastModifiedDate(new Date());
            order = orderRepository.save(order);
        }

        return ResponseHelper.buildOrderResponse(order);
    }

    protected Order updateOrder(Order existingOrder, Order newOrder){
        existingOrder.getOrderDetail().setValue(newOrder.getOrderDetail().getValue());
        existingOrder.getOrderDetail().setGrandTotal(newOrder.getOrderDetail().getGrandTotal());
        existingOrder.getOrderDetail().setNote(newOrder.getOrderDetail().getNote());
        existingOrder.getOrderDetail().setWeightInGram(newOrder.getOrderDetail().getWeightInGram());
        existingOrder.getOrderDetail().setDropAddress(newOrder.getOrderDetail().getDropAddress());
        existingOrder.getOrderDetail().setDropDistrictId(newOrder.getOrderDetail().getDropDistrictId());
        existingOrder.getOrderDetail().setDropEmail(newOrder.getOrderDetail().getDropEmail());
        existingOrder.getOrderDetail().setDropTel(newOrder.getOrderDetail().getDropTel());
        existingOrder.getOrderDetail().setShippingFee(newOrder.getOrderDetail().getShippingFee());
        existingOrder.getOrderDetail().setToPerson(newOrder.getOrderDetail().getToPerson());
        List<OrderProduct> newOrderProducts = newOrder.getOrderProducts();
        newOrderProducts = newOrderProducts.stream().map(op -> {
            op.setOrderId(existingOrder.getId());
            return op;
        }).collect(Collectors.toList());
        existingOrder.getOrderProducts().clear();
        existingOrder.getOrderProducts().addAll(newOrderProducts);
        existingOrder.setLastModifiedDate(new Date());
        return orderRepository.save(existingOrder);
    }
}

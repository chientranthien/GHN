package com.dalafarm.vendor.service.impl;

import com.dalafarm.vendor.model.Order;
import com.dalafarm.vendor.model.OrderProduct;
import com.dalafarm.vendor.model.OrderResponse;
import com.dalafarm.vendor.repository.OrderRepository;
import com.dalafarm.vendor.service.LogisticService;
import com.dalafarm.vendor.util.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;

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
            order = orderRepository.save(order);
        }

        return ResponseHelper.buildOrderResponse(order);
    }

    protected Order updateOrder(Order existingOrder, Order newOrder){
        existingOrder.setOrderDetail(newOrder.getOrderDetail());
        List<OrderProduct> newOrderProducts = newOrder.getOrderProducts();
        newOrderProducts = newOrderProducts.stream().map(op -> {
            op.setOrderId(existingOrder.getId());
            return op;
        }).collect(Collectors.toList());
        existingOrder.getOrderProducts().clear();
        existingOrder.getOrderProducts().addAll(newOrderProducts);
        return orderRepository.save(existingOrder);
    }
}

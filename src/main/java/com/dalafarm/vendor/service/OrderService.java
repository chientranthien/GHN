package com.dalafarm.vendor.service;

import com.dalafarm.vendor.model.Order;
import com.dalafarm.vendor.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LeeU on 9/3/2017.
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Iterable<Order> getAllOrdersForFrontend(){
        Iterable<Order> orders = orderRepository.findAll();

        return orders;
    }
}

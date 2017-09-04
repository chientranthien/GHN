package com.dalafarm.vendor.service;

import com.dalafarm.vendor.model.Order;
import com.dalafarm.vendor.model.OrderProduct;
import com.dalafarm.vendor.model.OrderStatusRequest;
import com.dalafarm.vendor.model.Product;
import com.dalafarm.vendor.repository.OrderRepository;
import com.dalafarm.vendor.repository.OrderStatusRequestRepository;
import com.dalafarm.vendor.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by LeeU on 9/3/2017.
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderStatusRequestRepository orderStatusRequestRepository;

    public Iterable<Order> getAllOrdersForFrontend(){
        Iterable<Order> orders = orderRepository.findAll();
        Iterable<Product> products = productRepository.findAll();
        return StreamSupport.stream(orders.spliterator(), true).map(o -> {
            List<OrderProduct> orderProductList = o.getOrderProducts();
            o.setProducts(orderProductList.stream().map(op -> {
                Product product = StreamSupport.stream(products.spliterator(), true)
                        .filter(p -> op.getProductId().compareTo(p.getId()) == 0)
                        .findFirst().orElse(null);
                return product;
            })
                    .collect(Collectors.toList()));
            return o;
        }).collect(Collectors.toList());
    }

    public void updateOrderStatus(OrderStatusRequest orderStatusRequest) {
        persistOrderStatusRequest(orderStatusRequest);
        Order order = orderRepository.findByOrderDetailOrderId(orderStatusRequest.getOrderId());
        if (order != null) {
            order.getOrderDetail().setStatusId(orderStatusRequest.getStatusId());
            order.setLastModifiedDate(orderStatusRequest.getActionTime());
            orderRepository.save(order);
        } else {
            throw new RuntimeException("Order not found");
        }
    }

    private void persistOrderStatusRequest(OrderStatusRequest orderStatusRequest) {
        orderStatusRequest.setCreatedDate(new Date());
        orderStatusRequestRepository.save(orderStatusRequest);
    }
}

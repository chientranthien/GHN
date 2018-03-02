package com.dalafarm.vendor.repository;

import com.dalafarm.vendor.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by chien on 8/3/17.
 */
public interface OrderRepository  extends CrudRepository<Order,Long> {
    Order findByOrderDetailOrderId(String orderId);

    Order findByOrderDetailVendorOrderId(String vendorOrderId);
}

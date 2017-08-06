package com.dalafarm.vendor.util;

import com.dalafarm.vendor.model.Order;

/**
 * Created by chien on 8/4/17.
 */
public interface LogisticBuilder<T> {
    T buildOrder(Order order);
}

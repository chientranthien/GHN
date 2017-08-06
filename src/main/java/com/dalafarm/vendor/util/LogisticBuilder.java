package com.example.ghn.util;

import com.example.ghn.model.Order;

/**
 * Created by chien on 8/4/17.
 */
public interface LogisticBuilder<T> {
    T buildOrder(Order order);
}

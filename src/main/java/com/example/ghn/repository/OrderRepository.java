package com.example.ghn.repository;

import com.example.ghn.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by chien on 8/3/17.
 */
public interface OrderRepository  extends CrudRepository<Order,Long> {

}

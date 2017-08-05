package com.example.ghn.repository;

import com.example.ghn.model.Order;
import com.example.ghn.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by chien on 8/5/17.
 */
public interface ProductRepository extends CrudRepository<Product,Long> {
    List<Product> findAllByIdInOrderByIdAsc(Iterable<Long> productIds);
}

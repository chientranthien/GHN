package com.dalafarm.vendor.repository;

import com.dalafarm.vendor.model.Order;
import com.dalafarm.vendor.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by chien on 8/5/17.
 */
public interface ProductRepository extends CrudRepository<Product,Long> {
    List<Product> findAllByIdInOrderByIdAsc(Iterable<Long> productIds);

    Product findBySku(String sku);
}

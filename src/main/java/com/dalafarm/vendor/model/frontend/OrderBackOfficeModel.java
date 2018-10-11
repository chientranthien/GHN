package com.dalafarm.vendor.model.frontend;

import com.dalafarm.vendor.model.OrderDetail;
import com.dalafarm.vendor.model.OrderProduct;
import com.dalafarm.vendor.model.Product;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * This object is used to display all order-related details on back-office system
 * Created by LeeU on 9/16/2017.
 */
@Data
public class OrderBackOfficeModel {
    private Long id;

    private List<Product> products;

    private List<OrderProduct> orderProducts;

    private OrderDetail orderDetail;

    private Date createdDate;

    private Date lastModifiedDate;

    private String status;

    private String address;

}

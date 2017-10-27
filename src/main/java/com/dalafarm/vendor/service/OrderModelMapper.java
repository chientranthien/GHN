package com.dalafarm.vendor.service;

import com.dalafarm.vendor.model.Order;
import com.dalafarm.vendor.model.OrderDetail;
import com.dalafarm.vendor.model.OrderProduct;
import com.dalafarm.vendor.model.Product;
import com.dalafarm.vendor.model.frontend.OrderBackOfficeModel;
import com.dalafarm.vendor.model.frontend.OrderModel;
import com.dalafarm.vendor.model.frontend.ProductModel;
import com.dalafarm.vendor.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by LeeU on 9/3/2017.
 */
@Slf4j
@Service
public class OrderModelMapper {
    @Value("${dalafarm.name}")
    public String fromPersonDefault;

    @Value("${dalafarm.address}")
    public String pickupAddressDefault;

    @Value("${dalafarm.districtId}")
    public String pickupDistrictIdDefault;

    @Value("${dalafarm.tel}")
    public String pickupTelDefault;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StatusMapper statusMapper;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");

    public Order toOrder(OrderModel orderModel) {
        Order order = new Order();
        order.setOrderDetail(toOrderDetail(orderModel));
        if (orderModel.getMeta() != null && orderModel.getMeta().getDate() != null) {
            try {
                Date createdDate = dateFormat.parse(orderModel.getMeta().getDate());
                order.setCreatedDate(createdDate);
                order.setLastModifiedDate(createdDate);
            } catch (ParseException e) {
                log.error("Error converting date", e);
            }
        }
        order.setOrderProducts(toOrderProducts(orderModel));
        order.setPromoCode(orderModel.getPromoCode());
        return order;
    }

    private OrderDetail toOrderDetail(OrderModel orderModel) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderModel.getOrderId());
        orderDetail.setFromPerson(fromPersonDefault);
        orderDetail.setGrandTotal(orderModel.getSubtotal());
        orderDetail.setPickupAddress(pickupAddressDefault);
        orderDetail.setPickupDistrictId(pickupDistrictIdDefault);
        orderDetail.setPickupTel(pickupTelDefault);

        orderDetail.setToPerson(orderModel.getInfo().getName());
        orderDetail.setDropAddress(orderModel.getInfo().getAddress());
        orderDetail.setDropDistrictId(orderModel.getInfo().getDistrictId());
        orderDetail.setDropTel(orderModel.getInfo().getPhone1());
        orderDetail.setDropEmail(orderModel.getInfo().getEmail());

        orderDetail.setNote(orderModel.getInfo().getAdditionalNote());
        orderDetail.setValue(orderModel.getSubtotal());
        orderDetail.setVendorId(orderModel.getShippingVendor());
        orderDetail.setShippingFee(Integer.parseInt(orderModel.getShippingCost()));
        return orderDetail;
    }

    private List<OrderProduct> toOrderProducts(OrderModel orderModel) {
        ProductModel[] productModels = orderModel.getProductModels();
        Iterable<Product> products = productRepository.findAll();
        return Arrays.stream(productModels)
                .filter(pm -> pm.getAmount() > 0)
                .map(pm -> {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setProductId(
                    StreamSupport.stream(products.spliterator(), true)
                            .filter(p -> pm.getName().equals(p.getSku())).findFirst()
                            .get().getId());
            orderProduct.setQuantity(pm.getAmount());
            return orderProduct;
        }).collect(Collectors.toList());
    }

    public OrderBackOfficeModel toOrderBackOfficeModel(Order order) {
        OrderBackOfficeModel orderBackOfficeModel = new OrderBackOfficeModel();
        orderBackOfficeModel.setId(order.getId());
        orderBackOfficeModel.setOrderDetail(order.getOrderDetail());
        orderBackOfficeModel.setProducts(order.getProducts());
        orderBackOfficeModel.setOrderProducts(order.getOrderProducts());
        orderBackOfficeModel.setCreatedDate(order.getCreatedDate());
        orderBackOfficeModel.setLastModifiedDate(order.getLastModifiedDate());
        Integer statusCode = order.getOrderDetail().getStatusId();
        orderBackOfficeModel.setStatus(statusMapper.getHumanReadableStatus(statusCode));
        return orderBackOfficeModel;
    }
}

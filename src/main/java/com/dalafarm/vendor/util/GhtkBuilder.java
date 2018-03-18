package com.dalafarm.vendor.util;

import com.dalafarm.vendor.model.*;
import com.dalafarm.vendor.model.ghtk.GhtkOrder;
import com.dalafarm.vendor.model.ghtk.GhtkOrderDetail;
import com.dalafarm.vendor.model.ghtk.GhtkProduct;
import com.dalafarm.vendor.repository.DistrictRepository;
import com.dalafarm.vendor.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by chien on 8/4/17.
 */
@Component
public class GhtkBuilder implements LogisticBuilder<GhtkOrder> {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public GhtkOrder buildOrder(Order order) {

        GhtkOrder ghtkOrder = new GhtkOrder();
        List<GhtkProduct> ghtkProducts = createGhtkProducts(order);
        ghtkOrder.setProducts(ghtkProducts);

        GhtkOrderDetail ghtkOrderDetail = createGhtkOrderDetail(order);
        ghtkOrder.setOrderDetail(ghtkOrderDetail);

        return ghtkOrder;
    }

    private List<GhtkProduct> createGhtkProducts(Order order) {
        List<OrderProduct> orderProducts = order.getOrderProducts();

        Collections.sort(orderProducts, (OrderProduct o1, OrderProduct o2) ->
                //no 0 case because Ids are distinct
                o1.getProductId() > o2.getProductId() ? 1 : -1
        );
        List<Long> productIds = order.getOrderProducts().stream().map(e -> e.getProductId()).collect(Collectors.toList());

        List<Product> products = productRepository.findAllByIdInOrderByIdAsc(productIds);

        return IntStream.range(0, products.size()).mapToObj(i -> {
            Product product = products.get(i);
            int quantity = orderProducts.get(i).getQuantity();
            float weightInKg = (float) (product.getWeight() / 1000.00);
            return new GhtkProduct(product.getName(), product.getPrice(), weightInKg, quantity);
        }).collect(Collectors.toList());
    }

    private GhtkOrderDetail createGhtkOrderDetail(Order order) {
        OrderDetail orderDetail = order.getOrderDetail();
        GhtkOrderDetail ghtkOrderDetail = new GhtkOrderDetail();
        ghtkOrderDetail.setFromPerson(orderDetail.getFromPerson());
        ghtkOrderDetail.setPickupMoney(orderDetail.getGrandTotal());
        ghtkOrderDetail.setPickupAddress(orderDetail.getPickupAddress());
        ghtkOrderDetail.setIsFreeship(orderDetail.isFreeship());

        String pickupDistrictId = orderDetail.getPickupDistrictId();
        District pickupDistrict = districtRepository.findOne(pickupDistrictId);
        ghtkOrderDetail.setPickupProvince(pickupDistrict.getProvince().getName());
        ghtkOrderDetail.setPickupDistrict(pickupDistrict.getName());
        ghtkOrderDetail.setPickupWard(orderDetail.getPickupWard());

        ghtkOrderDetail.setPickupTel(orderDetail.getPickupTel());
        ghtkOrderDetail.setToPerson(orderDetail.getToPerson());
        ghtkOrderDetail.setDropAddress(orderDetail.getDropAddress());

        String dropDistrictId = orderDetail.getDropDistrictId();
        District dropDistrict = districtRepository.findOne(dropDistrictId);

        ghtkOrderDetail.setDropProvince(dropDistrict.getProvince().getName());
        ghtkOrderDetail.setDropDistrict(dropDistrict.getName());
        ghtkOrderDetail.setDropWard(order.getOrderDetail().getDropWard());
        ghtkOrderDetail.setDropTel(orderDetail.getDropTel());
        ghtkOrderDetail.setNote(orderDetail.getNote());
        ghtkOrderDetail.setId(orderDetail.getOrderId());
        return ghtkOrderDetail;
    }
}

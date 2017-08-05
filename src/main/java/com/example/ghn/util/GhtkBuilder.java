package com.example.ghn.util;

import com.example.ghn.model.*;
import com.example.ghn.model.ghtk.GhtkOrder;
import com.example.ghn.model.ghtk.GhtkOrderDetail;
import com.example.ghn.model.ghtk.GhtkProduct;
import com.example.ghn.repository.DistrictRepository;
import com.example.ghn.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        List<OrderProduct> orderProducts = order.getOrderProducts();

        Collections.sort(orderProducts, (OrderProduct o1, OrderProduct o2) ->
                //no 0 case because Ids are distinct
                o1.getProductId() > o2.getProductId() ? 1 : -1
        );
        List<Long> productIds = order.getOrderProducts().stream().map(e -> e.getProductId()).collect(Collectors.toList());

        List<Product> products = productRepository.findAllByIdInOrderByIdAsc(productIds);

        List<GhtkProduct> ghtkProducts = IntStream.range(0, products.size()).mapToObj(i -> {
            Product product = products.get(i);
            int quantity = orderProducts.get(i).getQuantity();
            float weightInKg = (float) (product.getWeight() / 1000.00);
            return new GhtkProduct(product.getName(), product.getPrice(), weightInKg, quantity);
        }).collect(Collectors.toList());
        ghtkOrder.setProducts(ghtkProducts);
        OrderDetail orderDetail = order.getOrderDetail();
        GhtkOrderDetail ghtkOrderDetail = new GhtkOrderDetail();
        ghtkOrderDetail.setFromPerson(orderDetail.getFromPerson());
        ghtkOrderDetail.setPickupMoney(orderDetail.getCod());
        ghtkOrderDetail.setPickupAddress(orderDetail.getPickupAddress());

        String pickupDistrictId = orderDetail.getPickupDistrictId();
        District pickupDistrict = districtRepository.findOne(pickupDistrictId);
        ghtkOrderDetail.setPickupProvince(pickupDistrict.getProvince().getName());
        ghtkOrderDetail.setPickupDistrict(pickupDistrict.getName());

        ghtkOrderDetail.setPickupTel(orderDetail.getPickupTel());
        ghtkOrderDetail.setToPerson(orderDetail.getToPerson());
        ghtkOrderDetail.setDropAddress(orderDetail.getDropAddress());

        String dropDistrictId = orderDetail.getDropDistrictId();
        District dropDistrict = districtRepository.findOne(dropDistrictId);
        ghtkOrderDetail.setDropProvince(dropDistrict.getProvince().getName());
        ghtkOrderDetail.setDropDistrict(dropDistrict.getName());


        ghtkOrderDetail.setDropTel(orderDetail.getDropTel());
        ghtkOrderDetail.setNote(orderDetail.getNote());
        ghtkOrderDetail.setId(orderDetail.getDummyId());

        ghtkOrder.setOrderDetail(ghtkOrderDetail);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println(objectMapper.writeValueAsString(ghtkOrder));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ghtkOrder;
    }
}

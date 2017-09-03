package com.dalafarm.vendor.service.impl;

import com.dalafarm.vendor.controller.StatusController;
import com.dalafarm.vendor.model.*;
import com.dalafarm.vendor.model.ghtk.GhtkOrderResponse;
import com.dalafarm.vendor.repository.DistrictRepository;
import com.dalafarm.vendor.repository.OrderRepository;
import com.dalafarm.vendor.repository.ProvinceRepository;
import com.dalafarm.vendor.service.LogisticService;
import com.dalafarm.vendor.util.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

/**
 * Created by chien on 8/13/17.
 */

@Service(value="tinLogisticService")
@Qualifier("tinLogistic")
public class TinLogisticService extends AbstractLogisticService {
    private final static int VENDOR_ID = 2;
    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderFeeResponse calculateServiceFee(OrderSummary orderSummary) {

        District dropDistrict = districtRepository.findOne(orderSummary.getDropDistrictId());
        Province dropProvince = dropDistrict.getProvince();

        OrderFeeResponse orderFeeResponse = new OrderFeeResponse();
        orderFeeResponse.setSuccess(true);
        orderFeeResponse.setMessage("Tin logistic service");
        orderFeeResponse.setTotalFee(dropProvince.getGroup().calculateServiceFee(orderSummary.getWeight()));
        orderFeeResponse.setVendorId(VENDOR_ID);
        return orderFeeResponse;
    }

    @Override
    public OrderStatusResponse getOrderStatus(String supplierOrderId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Response activateOrder(Order order) {
        Response response = activateOrder(order, (o) -> {
            orderRepository.save(o);
        });

        return response;
    }


}

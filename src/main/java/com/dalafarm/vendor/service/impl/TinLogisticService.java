package com.dalafarm.vendor.service.impl;

import com.dalafarm.vendor.model.*;
import com.dalafarm.vendor.repository.DistrictRepository;
import com.dalafarm.vendor.repository.ProvinceRepository;
import com.dalafarm.vendor.service.LogisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by chien on 8/13/17.
 */

@Service
@Qualifier("tinLogistic")
public class TinLogisticService implements LogisticService {

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public OrderFeeResponse calculateServiceFee(OrderSummary orderSummary) {

        District dropDistrict = districtRepository.findOne(orderSummary.getDropDistrictId());
        Province dropProvince = dropDistrict.getProvince();

        OrderFeeResponse orderFeeResponse = new OrderFeeResponse();
        orderFeeResponse.setSuccess(true);
        orderFeeResponse.setMessage("Tin logistic service");
        orderFeeResponse.setTotalFee(dropProvince.getGroup().calculateServiceFee(orderSummary.getWeight()));

        return orderFeeResponse;
    }

    @Override
    public OrderResponse order(Order order) {
        throw new UnsupportedOperationException();
    }

    @Override
    public OrderStatusResponse getOrderStatus(String supplierOrderId) {
        throw new UnsupportedOperationException();
    }


}

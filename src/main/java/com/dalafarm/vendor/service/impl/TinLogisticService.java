package com.dalafarm.vendor.service.impl;

import com.dalafarm.vendor.model.*;
import com.dalafarm.vendor.repository.DistrictRepository;
import com.dalafarm.vendor.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

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
            o.setLastModifiedDate(new Date());
            orderRepository.save(o);
        });

        return response;
    }


}

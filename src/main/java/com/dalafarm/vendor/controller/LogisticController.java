package com.dalafarm.vendor.controller;

import com.dalafarm.vendor.model.*;
import com.dalafarm.vendor.repository.OrderRepository;
import com.dalafarm.vendor.service.LogisticService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by chien on 7/29/17.
 */
@RestController
@RequestMapping("v1/logistic")
public class LogisticController {

    @Autowired
    LogisticService ghtkService;

    @RequestMapping(value = "shipping-fee", method = RequestMethod.POST)
    public OrderFeeResponse calculateServiceFee(@RequestBody @Valid OrderSummary orderSummary) {
        return ghtkService.calculateServiceFee(orderSummary);
    }

}

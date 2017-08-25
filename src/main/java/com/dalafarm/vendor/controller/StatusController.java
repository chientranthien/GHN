package com.dalafarm.vendor.controller;

import com.dalafarm.vendor.model.Status;
import com.dalafarm.vendor.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chien on 8/14/17.
 */
@RestController
@RequestMapping("v1/order-statuses")
public class StatusController {
    @Autowired
    StatusRepository statusRepository;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Status getStatus(@PathVariable("id") Integer statusId) {
        return statusRepository.findOne(statusId);
    }

    @RequestMapping(method = RequestMethod.GET)
    Iterable<Status> getAll() {
        return statusRepository.findAll();
    }
}


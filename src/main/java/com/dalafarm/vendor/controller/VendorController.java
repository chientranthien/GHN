package com.dalafarm.vendor.controller;

import com.dalafarm.vendor.model.Vendor;
import com.dalafarm.vendor.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chien on 8/15/17.
 */
@RestController
@RequestMapping("v1/vendors")
public class VendorController {
    @Autowired
    VendorRepository vendorRepository;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Vendor getVendor(@PathVariable("id") Integer statusId) {
        return vendorRepository.findOne(statusId);
    }

    @RequestMapping(method = RequestMethod.GET)
    Iterable<Vendor> getAll() {
        return vendorRepository.findAll();
    }
}

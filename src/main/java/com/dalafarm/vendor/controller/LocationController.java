package com.dalafarm.vendor.controller;

import com.dalafarm.vendor.model.District;
import com.dalafarm.vendor.model.Province;
import com.dalafarm.vendor.model.Ward;
import com.dalafarm.vendor.repository.DistrictRepository;
import com.dalafarm.vendor.repository.ProvinceRepository;
import com.dalafarm.vendor.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Created by chien on 8/6/17.
 */
@RestController
@RequestMapping("v1")
public class LocationController {

    @Autowired
    ProvinceRepository provinceRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    WardRepository wardRepository;

    @RequestMapping(value = "provinces",method = RequestMethod.GET)
    Iterable<Province> getAll() {
        return provinceRepository.findAll();
    }

    @RequestMapping(value = "province/{provinceId}/districts", method = RequestMethod.GET)
    Iterable<District> getByProvinceId(@PathVariable String provinceId) {
        return districtRepository.findByProvinceId(provinceId);
    }

    @RequestMapping(value = "province/{provinceId}/wards", method = RequestMethod.GET)
    Iterable<Ward> getWardByProvinceId(@PathVariable String provinceId) {
        return wardRepository.findWardByProvinceId(provinceId);
    }

}

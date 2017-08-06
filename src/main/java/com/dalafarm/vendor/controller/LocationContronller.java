package com.dalafarm.vendor.controller;

import com.dalafarm.vendor.model.District;
import com.dalafarm.vendor.model.Province;
import com.dalafarm.vendor.repository.DistrictRepository;
import com.dalafarm.vendor.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chien on 8/6/17.
 */
@RestController
@RequestMapping("v1")
public class LocationContronller {

    @Autowired
    ProvinceRepository provinceRepository;

    @Autowired
    DistrictRepository districtRepository;

    @RequestMapping(value = "provinces",method = RequestMethod.GET)
    Iterable<Province> getAll() {
        return provinceRepository.findAll();
    }

    @RequestMapping(value = "districts", method = RequestMethod.GET)
    Iterable<District> getByProvinceId(String provinceId) {
        return districtRepository.findByProvinceId(provinceId);
    }

}

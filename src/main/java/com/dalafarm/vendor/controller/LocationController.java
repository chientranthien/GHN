package com.dalafarm.vendor.controller;

import com.dalafarm.vendor.model.District;
import com.dalafarm.vendor.model.Province;
import com.dalafarm.vendor.repository.DistrictRepository;
import com.dalafarm.vendor.repository.ProvinceRepository;
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

    @CrossOrigin(origins = {"https://dalafarm.com.vn","http://preview.dalafarm.com.vn","http://localhost:1313"})
    @RequestMapping(value = "provinces",method = RequestMethod.GET)
    Iterable<Province> getAll() {
        return provinceRepository.findAll();
    }

    @CrossOrigin(origins = {"https://dalafarm.com.vn","http://preview.dalafarm.com.vn","http://localhost:1313"})
    @RequestMapping(value = "province/{provinceId}/districts", method = RequestMethod.GET)
    Iterable<District> getByProvinceId(@PathVariable String provinceId) {
        return districtRepository.findByProvinceId(provinceId);
    }

}

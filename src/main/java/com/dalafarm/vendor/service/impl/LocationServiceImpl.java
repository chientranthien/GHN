package com.dalafarm.vendor.service.impl;

import com.dalafarm.vendor.model.District;
import com.dalafarm.vendor.repository.DistrictRepository;
import com.dalafarm.vendor.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public String getDistrictAsStr(String districtId) {
        District district = districtRepository.findOne(districtId);
        return district.getName();
    }

    @Override
    public String getDistrictNProvinceAsStr(String districtId) {
        District district = districtRepository.findOne(districtId);
        StringBuilder districtNProvinceAsStr = new StringBuilder();
        districtNProvinceAsStr
                .append(district.getType())
                .append(" ")
                .append(district.getName())
                .append(", ")
                .append(district.getProvince().getName());
        return districtNProvinceAsStr.toString();
    }
}

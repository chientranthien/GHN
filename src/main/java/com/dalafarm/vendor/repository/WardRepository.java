package com.dalafarm.vendor.repository;

import com.dalafarm.vendor.model.District;
import com.dalafarm.vendor.model.Ward;
import org.springframework.data.repository.CrudRepository;

public interface WardRepository extends CrudRepository<District, String> {
    Iterable<Ward> findWardByProvinceId(String provinceId);
}

package com.dalafarm.vendor.repository;

import com.dalafarm.vendor.model.Ward;
import org.springframework.data.repository.CrudRepository;

public interface WardRepository extends CrudRepository<Ward, String> {
    Iterable<Ward> findWardByDistrictId(String districtId);
}

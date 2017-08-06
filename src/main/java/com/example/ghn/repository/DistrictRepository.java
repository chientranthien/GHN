package com.example.ghn.repository;

import com.example.ghn.model.District;
import com.example.ghn.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by chien on 8/5/17.
 */
public interface DistrictRepository extends CrudRepository<District, String> {
    Iterable<District> findByProvinceId(String provinceId);
}

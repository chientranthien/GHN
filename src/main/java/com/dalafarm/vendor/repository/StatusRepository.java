package com.dalafarm.vendor.repository;

import com.dalafarm.vendor.model.Status;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by chien on 8/5/17.
 */
public interface StatusRepository extends CrudRepository<Status,Integer> {
    Status findByGhtkStatusId(Integer ghtkStatusId);
}

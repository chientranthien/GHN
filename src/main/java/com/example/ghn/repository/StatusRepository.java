package com.example.ghn.repository;

import com.example.ghn.model.Status;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by chien on 8/5/17.
 */
public interface StatusRepository extends CrudRepository<Status,Integer> {
    Status findByGhtkStatusId(Integer ghtkStatusId);
}

package com.dalafarm.vendor.service;

import com.dalafarm.vendor.model.Status;
import com.dalafarm.vendor.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Map logistic vendor specific status into status that makes sense for customers
 * Created by Vu on 8/13/2017.
 */
@Service
public class StatusMapper {
	@Autowired
	private StatusRepository repository;

	public String mapVendorSpecificStatus(int statusCode, String vendorSpecificStatus) {
		Status status = repository.findByGhtkStatusId(statusCode);
		if (status != null) {
			return status.getName();
		} else {
			return vendorSpecificStatus;
		}
	}

	public Integer mapVendorStatusIdToSelfStatusId(Integer statusId){
		Status status = repository.findByGhtkStatusId(statusId);
		return status.getId();
	}
}

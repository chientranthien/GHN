package com.dalafarm.vendor.controller;

/**
 * Created by EVL1HC on 8/13/2017.
 */
public class ResourceNotFoundException extends RuntimeException {
	private final String propertyName;
	private final String errorMessage;

	public ResourceNotFoundException(String propertyName, String errorMessage) {
		this.propertyName = propertyName;
		this.errorMessage = errorMessage;
	}
}

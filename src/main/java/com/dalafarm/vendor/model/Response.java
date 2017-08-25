package com.dalafarm.vendor.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by chien on 8/14/17.
 */
public class Response extends ResourceSupport{
    private boolean success;

    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

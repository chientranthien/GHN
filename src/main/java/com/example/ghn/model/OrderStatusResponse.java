package com.example.ghn.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.Id;

/**
 * Created by chien on 8/5/17.
 */
public class OrderStatusResponse {

    private Integer id;

    private String name;

    private String lastUpdatedDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
}

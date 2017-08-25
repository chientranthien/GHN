package com.dalafarm.vendor.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by chien on 8/15/17.
 */
@Entity
public class Vendor {
    @Id
    private Integer id;

    private String name;

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
}

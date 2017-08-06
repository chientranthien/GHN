package com.dalafarm.vendor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by chien on 8/5/17.
 */
@Entity
public class Province {
    @Id
    @Column(name = "provinceid")
    private String id;

    private  String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.dalafarm.vendor.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by chien on 8/5/17.
 */
@Entity
@Table(name = "STATUS")
public class Status {
    @Id
    private Integer id;

    private String name;

    private Integer ghtkStatusId;

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

    public Integer getGhtkStatusId() {
        return ghtkStatusId;
    }

    public void setGhtkStatusId(Integer ghtkStatusId) {
        this.ghtkStatusId = ghtkStatusId;
    }
}

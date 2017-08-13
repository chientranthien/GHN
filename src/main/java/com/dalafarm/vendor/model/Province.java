package com.dalafarm.vendor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by chien on 8/5/17.
 */
@Entity
public class Province {
    @Id
    @Column(name = "provinceid")
    private String id;

    private String name;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @Column(name = "TIN_LOGISTIC_GROUP")
    private TinLogisticGroup group;

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

    public TinLogisticGroup getGroup() {
        return group;
    }

    public void setGroup(TinLogisticGroup group) {
        this.group = group;
    }
}

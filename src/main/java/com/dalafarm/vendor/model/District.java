package com.dalafarm.vendor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by chien on 8/5/17.
 */
@Entity
public class District {
    @Id
    @Column(name = "districtid")
    private String id;

    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "provinceid"
    )
    private Province province;

    private String type;

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
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

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}

package com.dalafarm.vendor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Ward {
    @Id
    @Column(name = "wardid")
    private String id;

    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "districtid"
    )
    private District district;

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

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
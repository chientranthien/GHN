package com.example.ghn.model;

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

    @ManyToOne
    @JoinColumn(
            name = "provinceid"
    )
    private Province province;

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

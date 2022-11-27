package com.fixed_asset.appasset.infrastructure.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "areas")
public class AreaDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String code;
    private String city;

    @OneToMany(mappedBy = "area", cascade = {CascadeType.ALL})
    private List<AssetDB> assets;

    public AreaDB() {
    }



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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<AssetDB> getAssets() {
        return assets;
    }

    public void setAssets(List<AssetDB> assets) {
        this.assets = assets;
    }
}

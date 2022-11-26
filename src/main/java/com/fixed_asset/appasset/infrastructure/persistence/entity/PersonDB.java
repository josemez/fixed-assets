package com.fixed_asset.appasset.infrastructure.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persons")
public class PersonDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="full_name")
    private String fullName;
    private int identifier;

    @OneToMany(mappedBy = "person", cascade = {CascadeType.ALL})
    private List<AssetDB> assets;

    public PersonDB() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public List<AssetDB> getAssets() {
        return assets;
    }

    public void setAssets(List<AssetDB> assets) {
        this.assets = assets;
    }
}

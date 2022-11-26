package com.fixed_asset.appasset.infrastructure.persistence;

import com.fixed_asset.appasset.domain.Asset;
import com.fixed_asset.appasset.domain.port.AssetRepository;
import com.fixed_asset.appasset.infrastructure.persistence.mapper.AssetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AssetRepositoryImp implements AssetRepository {

    @Autowired
    private AssetCrudRepository repository;

    @Autowired
    private AssetMapper mapper;

    @Override
    public Asset searchAll() {
        return null;
    }

    @Override
    public Asset searchByType() {
        return null;
    }

    @Override
    public Asset searchByDate() {
        return null;
    }

    @Override
    public Asset searchBySerial() {
        return null;
    }

    @Override
    public Asset create() {
        return null;
    }

    @Override
    public Asset Update() {
        return null;
    }
}

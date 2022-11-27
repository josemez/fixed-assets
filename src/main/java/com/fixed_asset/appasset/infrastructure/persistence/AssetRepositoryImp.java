package com.fixed_asset.appasset.infrastructure.persistence;

import com.fixed_asset.appasset.domain.Asset;
import com.fixed_asset.appasset.domain.port.AssetRepository;
import com.fixed_asset.appasset.infrastructure.persistence.entity.AssetDB;
import com.fixed_asset.appasset.infrastructure.persistence.mapper.AssetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

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
    public Asset searchByType(String type) {
        return null;
    }

    @Override
    public Asset searchByDate(LocalDateTime date) {
        return null;
    }

    @Override
    public Asset searchBySerial(String serial) {
        return null;
    }

    @Override
    public Asset create(Asset asset) {
        AssetDB a = repository.save(mapper.toDb(asset));
        return mapper.toDomain(a);
    }

    @Override
    public Asset Update(Asset asset) {
        return null;
    }
}

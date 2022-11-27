package com.fixed_asset.appasset.domain.services;

import com.fixed_asset.appasset.domain.Asset;
import com.fixed_asset.appasset.domain.port.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetServices {

    @Autowired
    private AssetRepository repository;

    public AssetServices(AssetRepository repository) {
        this.repository = repository;
    }

    public Asset create(Asset asset) {
        return repository.create(asset);
    }
}

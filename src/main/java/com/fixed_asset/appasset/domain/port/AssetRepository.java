package com.fixed_asset.appasset.domain.port;

import com.fixed_asset.appasset.domain.Asset;

import java.time.LocalDateTime;

public interface AssetRepository {
    Asset searchAll();
    Asset searchByType(String type);
    Asset searchByDate(LocalDateTime date);
    Asset searchBySerial(String serial);
    Asset create(Asset asset);
    Asset Update(Asset asset);
}

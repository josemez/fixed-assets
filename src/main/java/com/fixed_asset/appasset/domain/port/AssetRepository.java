package com.fixed_asset.appasset.domain.port;

import com.fixed_asset.appasset.domain.Asset;
import com.fixed_asset.appasset.exceptions.ApiException;
import com.fixed_asset.appasset.exceptions.BadRequestException;

import java.time.LocalDateTime;

public interface AssetRepository {
    Asset searchAll();
    Asset searchByType(String type);
    Asset searchByDate(LocalDateTime date);
    Asset searchBySerial(String serial);
    Asset create(Asset asset) throws BadRequestException, ApiException;
    Asset Update(Asset asset);
}

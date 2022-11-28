package com.fixed_asset.appasset.domain.port;

import com.fixed_asset.appasset.domain.Asset;
import com.fixed_asset.appasset.exceptions.ApiException;
import com.fixed_asset.appasset.exceptions.InternalErrorException;

import java.time.LocalDateTime;
import java.util.List;

public interface AssetRepository {
    Asset searchAll();
    List<Asset> searchByType(String type) throws ApiException;
    List<Asset> searchByDate(LocalDateTime date) throws  ApiException;
    Asset searchBySerial(String serial) throws ApiException;
    Asset create(Asset asset) throws ApiException;
    Asset Update(Asset asset) throws InternalErrorException, ApiException;
}

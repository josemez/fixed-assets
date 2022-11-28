package com.fixed_asset.appasset.domain.port;

import com.fixed_asset.appasset.domain.Asset;
import com.fixed_asset.appasset.exceptions.ApiException;
import com.fixed_asset.appasset.exceptions.InternalErrorException;

import java.time.LocalDateTime;
import java.util.List;

/***
 * Puerto - Definicion de contrato de dominio para la entidad activo
 */
public interface AssetRepository {
    List<Asset> searchAll(int page, int size) throws ApiException;
    List<Asset> searchByType(String type) throws ApiException;
    List<Asset> searchByDate(LocalDateTime date) throws  ApiException;
    Asset searchBySerial(String serial) throws ApiException;
    Asset findById(Integer id) throws ApiException;
    Asset create(Asset asset) throws ApiException;
    Asset Update(Asset asset) throws ApiException;
}

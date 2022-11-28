package com.fixed_asset.appasset.domain.services;

import com.fixed_asset.appasset.domain.Asset;
import com.fixed_asset.appasset.domain.port.AssetRepository;
import com.fixed_asset.appasset.exceptions.ApiException;
import com.fixed_asset.appasset.exceptions.InternalErrorException;
import com.fixed_asset.appasset.exceptions.ValidationError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/***
 * Clase que contiene los servicios de la capa de negocio para el dominio de activos
 */
@Service
public class AssetServices {

    @Autowired
    private AssetRepository repository;

    public AssetServices(AssetRepository repository) {
        this.repository = repository;
    }

    /***
     * Servicio crear activos
     * @param asset
     * @return
     * @throws ApiException
     */
    public Asset create(Asset asset) throws ApiException {

        if (valiteDates(asset.getDischargeDate(), asset.getDatePurchase())) {
            throw new InternalErrorException(ValidationError.INVALID_DATES);
        }
        return repository.create(asset);
    }

    /***
     * Servicio buscar todos los activos paginados
     * @param page
     * @param size
     * @return
     * @throws ApiException
     */
    public List<Asset> searchAll(int page, int size) throws ApiException {
        return repository.searchAll(page, size);
    }

    /***
     * Servicio buscar activo por tipo
     * @param type
     * @return
     * @throws ApiException
     */
    public List<Asset> findByType(String type) throws ApiException {
        return repository.searchByType(type);
    }

    /***
     * Servicio buscar activo por serial
     * @param serial
     * @return
     * @throws ApiException
     */
    public   Asset findBySerial(String serial) throws ApiException {
        return repository.searchBySerial(serial);
    }

    /***
     * Servicio buscar activo por fecha de alta
     * @param date
     * @return
     * @throws ApiException
     */
    public List<Asset> findByDatePurchase(LocalDateTime date) throws ApiException {

        return repository.searchByDate(date);
    }

    /***
     * Servicio actualizacion de activo
     * @param asset
     * @return
     * @throws ApiException
     */
    public Asset update(Asset asset) throws ApiException {

        Asset x = repository.findById(asset.getId());
        if (valiteDates(x.getDischargeDate(), x.getDatePurchase())) {
            throw new InternalErrorException(ValidationError.INVALID_DATES);
        }
        x.setSerial(asset.getSerial());
        x.setDischargeDate(asset.getDischargeDate());
        return repository.Update(x);
    }



    private boolean valiteDates(LocalDateTime dischargeDate, LocalDateTime datePurchase) {
        return dischargeDate.isAfter(datePurchase);
    }
}

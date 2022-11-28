package com.fixed_asset.appasset.domain.services;

import com.fixed_asset.appasset.domain.Asset;
import com.fixed_asset.appasset.domain.port.AssetRepository;
import com.fixed_asset.appasset.exceptions.ApiException;
import com.fixed_asset.appasset.exceptions.InternalErrorException;
import com.fixed_asset.appasset.exceptions.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AssetServices {

    @Autowired
    private AssetRepository repository;

    public AssetServices(AssetRepository repository) {
        this.repository = repository;
    }

    public Asset create(Asset asset) throws ApiException {

        if (valiteDates(asset.getDischargeDate(), asset.getDatePurchase())) {
            throw new InternalErrorException(ValidationError.INVALID_DATES);
        }
        return repository.create(asset);
    }

    private boolean valiteDates(LocalDateTime dischargeDate, LocalDateTime datePurchase) {
        return dischargeDate.isAfter(datePurchase);
    }
}

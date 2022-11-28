package com.fixed_asset.appasset.infrastructure.persistence;

import com.fixed_asset.appasset.domain.Asset;
import com.fixed_asset.appasset.infrastructure.persistence.entity.AssetDB;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AssetCrudRepository extends CrudRepository<AssetDB, Integer> {
    List<AssetDB> findByType(String type);
    List<AssetDB> findByDatePurchase(LocalDateTime datePurchase);
    AssetDB findBySerial(String serial);
}

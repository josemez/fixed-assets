package com.fixed_asset.appasset.infrastructure.persistence;

import com.fixed_asset.appasset.infrastructure.persistence.entity.AssetDB;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface AssetCrudRepository extends PagingAndSortingRepository<AssetDB, Integer> {
    List<AssetDB> findByType(String type);
    List<AssetDB> findByDatePurchase(LocalDateTime datePurchase);
    AssetDB findBySerial(String serial);
}

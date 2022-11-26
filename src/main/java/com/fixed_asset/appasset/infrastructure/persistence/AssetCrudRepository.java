package com.fixed_asset.appasset.infrastructure.persistence;

import com.fixed_asset.appasset.infrastructure.persistence.entity.AssetDB;
import org.springframework.data.repository.CrudRepository;

public interface AssetCrudRepository extends CrudRepository<AssetDB, Integer> {
}

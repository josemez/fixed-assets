package com.fixed_asset.appasset.infrastructure.persistence;

import com.fixed_asset.appasset.infrastructure.persistence.entity.AreaDB;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AreaCrudRepository extends PagingAndSortingRepository<AreaDB, Integer> {
}

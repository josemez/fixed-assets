package com.fixed_asset.appasset.infrastructure.persistence;

import com.fixed_asset.appasset.infrastructure.persistence.entity.PersonDB;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonCrudRepository extends PagingAndSortingRepository<PersonDB, Integer> {
}

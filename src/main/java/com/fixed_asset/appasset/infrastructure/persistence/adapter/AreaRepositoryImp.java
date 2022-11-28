package com.fixed_asset.appasset.infrastructure.persistence.adapter;


import com.fixed_asset.appasset.domain.Area;
import com.fixed_asset.appasset.domain.port.AreaRepository;
import com.fixed_asset.appasset.exceptions.ApiException;
import com.fixed_asset.appasset.exceptions.InternalErrorException;
import com.fixed_asset.appasset.exceptions.NotFoundException;
import com.fixed_asset.appasset.infrastructure.persistence.AreaCrudRepository;
import com.fixed_asset.appasset.infrastructure.persistence.entity.AreaDB;
import com.fixed_asset.appasset.infrastructure.persistence.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AreaRepositoryImp implements AreaRepository {

    @Autowired
    private AreaCrudRepository repository;

    @Autowired
    private AreaMapper mapper;

    @Override
    public List<Area> searchAll(int page, int size) throws ApiException {

        try {
            List<AreaDB> areas = repository.findAll(PageRequest.of(page, size)).getContent();
            if (areas.size() < 1) {
                throw new NotFoundException();
            }
            return mapper.toDomains(areas);
        }
        catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalErrorException("DATABASE_ERROR", e.getMessage());
        }
    }
}

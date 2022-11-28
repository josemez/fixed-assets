package com.fixed_asset.appasset.domain.services;

import com.fixed_asset.appasset.domain.Area;
import com.fixed_asset.appasset.domain.port.AreaRepository;
import com.fixed_asset.appasset.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServices {

    @Autowired
    private AreaRepository repository;

    public AreaServices(AreaRepository repository) {
        this.repository = repository;
    }

    public List<Area> searchAll(int page, int size) throws ApiException {
        return repository.searchAll(page, size);
    }
}

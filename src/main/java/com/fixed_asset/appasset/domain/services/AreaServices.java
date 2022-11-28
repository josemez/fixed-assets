package com.fixed_asset.appasset.domain.services;

import com.fixed_asset.appasset.domain.Area;
import com.fixed_asset.appasset.domain.port.AreaRepository;
import com.fixed_asset.appasset.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServices {

    /***
     * inyeccion del port repositorio
     */
    @Autowired
    private AreaRepository repository;

    /***
     *
     * @param repository
     */
    public AreaServices(AreaRepository repository) {
        this.repository = repository;
    }

    /***
     * Servicio para busqueda de areas
     * @param page
     * @param size
     * @return
     * @throws ApiException
     */
    public List<Area> searchAll(int page, int size) throws ApiException {
        return repository.searchAll(page, size);
    }
}

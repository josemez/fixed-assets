package com.fixed_asset.appasset.domain.port;

import com.fixed_asset.appasset.domain.Area;
import com.fixed_asset.appasset.domain.Person;
import com.fixed_asset.appasset.exceptions.ApiException;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 * Puerto - definicion de contrato para buscar areas
 */
public interface AreaRepository {
    List<Area> searchAll(int page, int size) throws ApiException;
}

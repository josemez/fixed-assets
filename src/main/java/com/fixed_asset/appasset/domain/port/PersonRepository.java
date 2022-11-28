package com.fixed_asset.appasset.domain.port;

import com.fixed_asset.appasset.domain.Person;
import com.fixed_asset.appasset.exceptions.ApiException;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 * Puerto - Definicion de contrato de dominio para la entidad persona
 */
public interface PersonRepository {
    List<Person> searchAll(int page, int size) throws ApiException;
}

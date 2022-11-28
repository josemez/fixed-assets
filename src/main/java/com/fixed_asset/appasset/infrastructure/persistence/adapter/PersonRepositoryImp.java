package com.fixed_asset.appasset.infrastructure.persistence.adapter;

import com.fixed_asset.appasset.domain.Person;
import com.fixed_asset.appasset.domain.port.PersonRepository;
import com.fixed_asset.appasset.exceptions.ApiException;
import com.fixed_asset.appasset.exceptions.InternalErrorException;
import com.fixed_asset.appasset.exceptions.NotFoundException;
import com.fixed_asset.appasset.infrastructure.persistence.PersonCrudRepository;
import com.fixed_asset.appasset.infrastructure.persistence.entity.PersonDB;
import com.fixed_asset.appasset.infrastructure.persistence.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepositoryImp implements PersonRepository {

    @Autowired
    private PersonCrudRepository repository;

    @Autowired
    private PersonMapper mapper;

    @Override
    public List<Person> searchAll(int page, int size) throws ApiException {

        try {
            List<PersonDB> persons = repository.findAll(PageRequest.of(page, size)).getContent();
            if (persons.size() < 1) {
                throw new NotFoundException();
            }
            return mapper.toDomains(persons);
        }
        catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalErrorException("DATABASE_ERROR", e.getMessage());
        }
    }
}

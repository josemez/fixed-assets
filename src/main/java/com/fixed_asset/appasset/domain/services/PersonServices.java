package com.fixed_asset.appasset.domain.services;

import com.fixed_asset.appasset.domain.Person;
import com.fixed_asset.appasset.domain.port.PersonRepository;
import com.fixed_asset.appasset.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {
    @Autowired
    private PersonRepository repository;

    public PersonServices(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> searchAll(int page, int size) throws ApiException {
        return repository.searchAll(page, size);
    }
}

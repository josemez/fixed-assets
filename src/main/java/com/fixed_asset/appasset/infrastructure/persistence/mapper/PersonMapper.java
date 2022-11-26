package com.fixed_asset.appasset.infrastructure.persistence.mapper;

import com.fixed_asset.appasset.domain.Person;
import com.fixed_asset.appasset.infrastructure.persistence.entity.PersonDB;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person toDomain(PersonDB personDB);
    List<Person> toDomains(List<PersonDB> persons);

    @InheritInverseConfiguration
    PersonDB toDb(Person person);
}

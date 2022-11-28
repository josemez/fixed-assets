package com.fixed_asset.appasset.controller;

import com.fixed_asset.appasset.domain.Area;
import com.fixed_asset.appasset.domain.Asset;
import com.fixed_asset.appasset.domain.Person;
import com.fixed_asset.appasset.domain.services.AreaServices;
import com.fixed_asset.appasset.domain.services.AssetServices;
import com.fixed_asset.appasset.domain.services.PersonServices;
import com.fixed_asset.appasset.exceptions.ApiException;
import com.fixed_asset.appasset.exceptions.BadRequestException;
import com.fixed_asset.appasset.exceptions.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    public PersonController(PersonServices service) {
        this.service = service;
    }

    @GetMapping("/search/{page}/{size}")
    public ResponseEntity<List<Person>> findByType(@PathVariable("page") int page,
                                                   @PathVariable("size") int size) throws ApiException {
        return new ResponseEntity<>(service.searchAll(page, size), HttpStatus.OK);
    }

}

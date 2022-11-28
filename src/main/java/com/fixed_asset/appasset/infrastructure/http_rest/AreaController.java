package com.fixed_asset.appasset.infrastructure.http_rest;

import com.fixed_asset.appasset.domain.Area;
import com.fixed_asset.appasset.domain.services.AreaServices;
import com.fixed_asset.appasset.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaServices service;

    public AreaController(AreaServices service) {
        this.service = service;
    }

    @GetMapping("/search/{page}/{size}")
    public ResponseEntity<List<Area>> findByType(@PathVariable("page") int page,
                                                 @PathVariable("size") int size) throws ApiException {
        return new ResponseEntity<>(service.searchAll(page, size), HttpStatus.OK);
    }

}

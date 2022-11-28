package com.fixed_asset.appasset.controller;

import com.fixed_asset.appasset.domain.Asset;
import com.fixed_asset.appasset.domain.services.AssetServices;
import com.fixed_asset.appasset.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fixed-asset")
public class AssetController {

    @Autowired
    private AssetServices service;

    @PostMapping("/create")
    public ResponseEntity<Asset> Create(@RequestBody Asset asset) throws ApiException {


        return new ResponseEntity<>(service.create(asset), HttpStatus.OK);
    }
}

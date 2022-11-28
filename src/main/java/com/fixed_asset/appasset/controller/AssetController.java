package com.fixed_asset.appasset.controller;

import com.fixed_asset.appasset.domain.Asset;
import com.fixed_asset.appasset.domain.services.AssetServices;
import com.fixed_asset.appasset.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/fixed-asset")
public class AssetController {

    @Autowired
    private AssetServices service;

    @PostMapping("/create")
    public ResponseEntity<Asset> create(@RequestBody Asset asset) throws ApiException {
        return new ResponseEntity<>(service.create(asset), HttpStatus.CREATED);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Asset>> findByType(@PathVariable("type") String type) throws ApiException {
        return new ResponseEntity<>(service.findByType(type), HttpStatus.OK);
    }

    @GetMapping("/serial/{serial}")
    public ResponseEntity<Asset> findBySerial(@PathVariable("serial") String serial) throws ApiException {
        return new ResponseEntity<>(service.findBySerial(serial), HttpStatus.OK);
    }

    @GetMapping("/date-purchase/{date}")
    public ResponseEntity<List<Asset>> findByDatePurchase( @PathVariable("date") String date)
            throws ApiException {
        LocalDateTime localdatetime = LocalDateTime.parse(date);

        return new ResponseEntity<>(service.findByDatePurchase(localdatetime), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Asset> update(@RequestBody Asset asset) throws ApiException {
        return new ResponseEntity<>(service.update(asset), HttpStatus.OK);
    }
}

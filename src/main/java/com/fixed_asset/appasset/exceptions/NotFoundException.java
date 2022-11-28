package com.fixed_asset.appasset.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiException {

    public NotFoundException() {
        super("NOT_FOUNT",
                "Resource not found, check search parameters",
                HttpStatus.NOT_FOUND);
    }

}
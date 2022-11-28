package com.fixed_asset.appasset.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ApiException {

    public BadRequestException(String code, String description) {
        super(code, description, HttpStatus.BAD_REQUEST);
    }

    public BadRequestException(ValidationError errorCode) {
        super(errorCode.getError(), errorCode.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
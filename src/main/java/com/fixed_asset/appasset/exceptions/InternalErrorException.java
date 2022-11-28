package com.fixed_asset.appasset.exceptions;

import org.springframework.http.HttpStatus;

public class InternalErrorException extends ApiException {

    public InternalErrorException(String code, String description) {
        super(code, description, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public InternalErrorException(ValidationError errorCode) {
        super(errorCode.getError(), errorCode.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

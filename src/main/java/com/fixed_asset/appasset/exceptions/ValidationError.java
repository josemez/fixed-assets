package com.fixed_asset.appasset.exceptions;


public enum ValidationError {

    INVALID_DATES("VALIDATION_DATE", "The discharge date is higher than the purchase date");

    private String error;
    private String message;

    ValidationError(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}

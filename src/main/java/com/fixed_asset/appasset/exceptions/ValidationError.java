package com.fixed_asset.appasset.exceptions;


public enum ValidationError {

    INVALID_DATES("VALIDATION_DATE", "The discharge date is higher than the purchase date"),
    INVALID_ASSIGNMENTS("VALIDATION_ASSIGNMET", "When creating the asset, it is only possible to assign it to an area or to a person"),
    INVALID_NO_ASSIGNMENTS("VALIDATION_NO_ASSIGNMET", "When creating the asset you must assign it to an area or a person");

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

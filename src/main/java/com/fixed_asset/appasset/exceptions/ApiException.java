package com.fixed_asset.appasset.exceptions;


import org.springframework.http.HttpStatus;

public class ApiException extends Exception {

    private final String code;
    private final HttpStatus statusCode;

    /**
     * Constructor with default status error = 500
     *
     * @param code   the error code of the exception
     * @param message the message to return the user
     */
    public ApiException(String code, String message) {
        super(message);
        this.code = code;
        statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    /**
     * @param code      the error code of the exception
     * @param message    the message to return the user
     * @param statusCode the API status error code
     */
    public ApiException(String code, String message, HttpStatus statusCode) {
        super(message);
        this.code = code;
        this.statusCode = statusCode;
    }

    /**
     * @param code      the error code of the exception
     * @param message    the message to return the user
     * @param cause      root exception
     */
    public ApiException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public String getCode() {
        return code;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}

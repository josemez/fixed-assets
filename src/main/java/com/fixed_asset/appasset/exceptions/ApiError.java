package com.fixed_asset.appasset.exceptions;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiError {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiError.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private String error;
    private String message;
    private List<String> cause;
    private Integer status;

    /**
     * Default contructor
     */
    public ApiError() {
        //Default contructor
    }

    /**
     * Custom contructor
     *
     * @param apiException
     */
    public ApiError(ApiException apiException) {
        this.error = apiException.getCode();
        this.message = apiException.getMessage();
        this.status = apiException.getStatusCode().value();
    }

    public ApiError(String error, String message, int status) {
        this.error = error;
        this.message = message;
        this.status = status;
    }

    public ApiError(String error, String message, int status, List<String> cause) {
        this.error = error;
        this.message = message;
        this.status = status;
        this.cause = cause;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getCause() {
        return cause;
    }

    public void setCause(List<String> cause) {
        this.cause = cause;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonIgnore
    public boolean isClientSideError() {
        return status != null && (status >= 400 && status < 500);
    }

    @Override
    public String toString() {

        try {
            return MAPPER.writeValueAsString(this);
        } catch (JsonProcessingException e) { // this should never happen.
            LOGGER.error("Error parsing ApiError to JSON", e);
            return String.format("{\"message\": \"%s\"}", this.getMessage());
        }
    }
}

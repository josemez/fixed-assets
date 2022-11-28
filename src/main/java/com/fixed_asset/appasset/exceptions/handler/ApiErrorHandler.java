package com.fixed_asset.appasset.exceptions.handler;


import com.fixed_asset.appasset.exceptions.ApiError;
import com.fixed_asset.appasset.exceptions.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

@ControllerAdvice
public class ApiErrorHandler {



    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiError> rulesForApiException(ApiException apiException) {
        ApiError apiError = new ApiError(apiException);

        return new ResponseEntity<>(apiError, apiException.getStatusCode());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiError> rulesForUriNotFound(NoHandlerFoundException e) {
        ApiError apiError = new ApiError();
        apiError.setStatus(HttpStatus.NOT_FOUND.value());
        apiError.setMessage(e.getMessage());
        apiError.setError("invalid_uri");

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    /**
     * Handler for validation errors
     *
     * @param ex catched
     * @return a ResponseEntity with an api error
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        ApiError apiError = new ApiError();
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());
        apiError.setError("validation_error");
        String message = processFieldErrors(fieldErrors);
        apiError.setMessage(message);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        Throwable mostSpecificCause = ex.getMostSpecificCause();
        ApiError apiError = new ApiError("validation_error", mostSpecificCause.getMessage(), HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    private String processFieldErrors(List<FieldError> fieldErrors) {
        StringBuilder stringBuilder = new StringBuilder();
        for (FieldError fieldError : fieldErrors) {
            if (!fieldError.equals(
                    fieldErrors.stream()
                            .findFirst()
                            .orElseThrow(() -> new NullPointerException("Unable to find an error to append."))
            )) {
                stringBuilder.append(". ");
            }
            stringBuilder.append(String.format("%s: %s", fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return stringBuilder.toString();
    }
}


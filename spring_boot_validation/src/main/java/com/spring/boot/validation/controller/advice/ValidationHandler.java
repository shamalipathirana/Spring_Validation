package com.spring.boot.validation.controller.advice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {


    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {


        List<String> errors=new ArrayList<>();

        for(FieldError fieldError: ex.getBindingResult().getFieldErrors()){
            String format= fieldError.getDefaultMessage();
            errors.add(format);
        }

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(), "Bad request", errors);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class ApiError {
        private int status;
        private String message;
        private List<String> errors;
    }

}

package com.cosmos.multifamily.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 *GlobalException
 *보완예정
 */
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handleException(HttpServletRequest request, Exception e) {
        return new ResponseEntity<>("GlobalExceptionHandler.handleExceptio" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

package com.cg.onlineshopping_application.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.onlineshopping_application.exception.CategoryNotFoundException;
import com.cg.onlineshopping_application.exception.ProductIdException;
import com.cg.onlineshopping_application.exception.ValidateProductException;


@RestControllerAdvice
public class ProductAdvice {


        @ExceptionHandler(value = { ValidateProductException.class })
        public ResponseEntity<String> handleException1(Exception ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }



}

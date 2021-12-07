package com.cg.onlineshopping_application.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.onlineshopping_application.dto.ErrorMessageDto;
import com.cg.onlineshopping_application.exception.CategoryIdException;
import com.cg.onlineshopping_application.exception.ValidateCategoryException;



@RestControllerAdvice
public class CategoryAdvice {
	@ExceptionHandler(value = { ValidateCategoryException.class })
	public ResponseEntity<String> handleException1(Exception ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}


}

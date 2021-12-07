package com.cg.onlineshopping_application.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.onlineshopping_application.dto.ErrorMessageDto;
import com.cg.onlineshopping_application.exception.CustomerIdException;
import com.cg.onlineshopping_application.exception.UserNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateCustomerException;

@RestControllerAdvice
public class CustomerAdvice {
	
	@ExceptionHandler(CustomerIdException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleCustomerException(CustomerIdException exception) {
		return new ErrorMessageDto(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
		
	}
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleUserException(UserNotFoundException exception) {
		return new ErrorMessageDto(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler(ValidateCustomerException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleCustomerException(ValidateCustomerException exception) {
		return new ErrorMessageDto(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
}

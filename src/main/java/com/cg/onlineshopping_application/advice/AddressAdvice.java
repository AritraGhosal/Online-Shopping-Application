package com.cg.onlineshopping_application.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.onlineshopping_application.dto.ErrorMessageDto;
import com.cg.onlineshopping_application.exception.AddressIdException;
import com.cg.onlineshopping_application.exception.CustomerNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateAddressException;


@RestControllerAdvice
public class AddressAdvice{
	
	public AddressAdvice() {
		super();
	}
	@ExceptionHandler(AddressIdException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleAddressException(AddressIdException exception) {
		return new ErrorMessageDto(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleCustomerException(CustomerNotFoundException exception) {
		return new ErrorMessageDto(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler(ValidateAddressException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleAddressException(ValidateAddressException exception) {
		return new ErrorMessageDto(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
}

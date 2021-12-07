package com.cg.onlineshopping_application.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.onlineshopping_application.dto.ErrorMessageDto;
import com.cg.onlineshopping_application.exception.AddressNotFoundException;
import com.cg.onlineshopping_application.exception.CustomerNotFoundException;
import com.cg.onlineshopping_application.exception.OrderIdException;
import com.cg.onlineshopping_application.exception.ProductNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateOrderException;

@RestControllerAdvice
public class Order1Advice {
	
	@ExceptionHandler(OrderIdException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleOrderException(OrderIdException exception) {
		return new ErrorMessageDto(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
		
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleCustomerException(CustomerNotFoundException exception) {
		return new ErrorMessageDto(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleProductException(ProductNotFoundException exception) {
		return new ErrorMessageDto(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler(AddressNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleAddressException(AddressNotFoundException exception) {
		return new ErrorMessageDto(exception.getMessage(),HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler(ValidateOrderException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleOrderException(ValidateOrderException exception) {
		return new ErrorMessageDto(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
}
package com.cg.onlineshopping_application.controller;

import java.util.List;

import com.cg.onlineshopping_application.exception.*;
import com.cg.onlineshopping_application.model.Order1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping_application.dto.Order1Dto;
import com.cg.onlineshopping_application.dto.SuccessMessageDto;
import com.cg.onlineshopping_application.service.IOrderServiceImp;
import com.cg.onlineshopping_application.util.FixedValues;

@RestController
@RequestMapping("/order")
public class OrderController
{
	@Autowired
	IOrderServiceImp orderService;
	
	@PostMapping("/addorder")
	public SuccessMessageDto addOrder(@RequestBody Order1Dto order1Dto) throws ValidateOrderException, CustomerNotFoundException,AddressNotFoundException, CartNotFoundException
	{
		Order1 order1= orderService.addOrder(order1Dto);
		return new SuccessMessageDto(FixedValues.ORDER_ADDED+ order1.getOrdId());
	}
	
	@DeleteMapping("/removeorder/{id}")
		public SuccessMessageDto removeOrder(@PathVariable("id") Integer ordId) throws OrderIdException
		{
			orderService.removeOrder(ordId);
			return new SuccessMessageDto(FixedValues.ORDER_REMOVED);
		}
	
	@PutMapping("/updateorder")
	public SuccessMessageDto updateOrder(@RequestBody Order1Dto order1Dto) throws OrderIdException, ValidateOrderException, CustomerNotFoundException, CartNotFoundException, AddressNotFoundException
	{
		Order1 order1=orderService.updateOrder(order1Dto);
		return new SuccessMessageDto(FixedValues.ORDER_UPDATED+order1.getOrdId());
	}
	
	@GetMapping("/getorderbyid/{id}")
	public Order1 viewOrderById(@PathVariable("id")Integer ordId) throws OrderIdException 
	{
	
		return orderService.viewOrder(ordId);	
	}
	
	@GetMapping("/getorderbyaddress/{id}")
	public List<Order1> viewAllOrdersByLocation(@PathVariable("id") Integer addressId) throws AddressNotFoundException
	{
		return orderService.viewAllOrdersByLocation(addressId);	
	}
	
	@GetMapping("/getorderbycustomer/{id}")
	public List<Order1> viewAllOrderByCustomerId(@PathVariable("id") Integer customerId) throws CustomerNotFoundException
	{
		return orderService.viewAllOrderByCustomerId(customerId);	
	}
}
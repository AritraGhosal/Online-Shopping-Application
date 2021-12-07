package com.cg.onlineshopping_application.service;

import java.util.List;

import com.cg.onlineshopping_application.dto.CustomerDto;
import com.cg.onlineshopping_application.entity.Customer;
import com.cg.onlineshopping_application.exception.CustomerIdException;
import com.cg.onlineshopping_application.exception.UserNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateCustomerException;

public interface ICustomerService {
	public Customer addCustomer(CustomerDto customerdto)throws ValidateCustomerException,UserNotFoundException;
	public Customer updateCustomer(CustomerDto customerdto)throws CustomerIdException,UserNotFoundException,ValidateCustomerException;
	public boolean removeCustomer(Integer customerId)throws CustomerIdException;
	public Customer viewCustomerById(Integer customerId)throws CustomerIdException;
	public List<Customer> viewAllCustomers()throws CustomerIdException;
	public Customer getCustomerData(Integer userId);

}

package com.cg.onlineshopping_application.service;

import java.util.List;

import com.cg.onlineshopping_application.dto.AddressDto;
import com.cg.onlineshopping_application.exception.AddressIdException;
import com.cg.onlineshopping_application.exception.CustomerNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateAddressException;
import com.cg.onlineshopping_application.model.Address;
import com.cg.onlineshopping_application.model.Customer;

public interface IAddressService {

	public Address addAddress(AddressDto addressdto)throws ValidateAddressException,CustomerNotFoundException;
	public Address updateAddress(AddressDto addressdto) throws AddressIdException,CustomerNotFoundException,ValidateAddressException;
	public boolean removeAddress(Integer addressId)throws AddressIdException;
	public List<Address> viewAllAddress()throws AddressIdException;
	public Address viewAddress(Integer addressId)throws AddressIdException;
	public Address getAddressData(Integer customerId);
	
}

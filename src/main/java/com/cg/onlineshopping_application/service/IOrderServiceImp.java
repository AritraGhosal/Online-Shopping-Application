package com.cg.onlineshopping_application.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cg.onlineshopping_application.exception.*;
import com.cg.onlineshopping_application.model.*;
import com.cg.onlineshopping_application.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping_application.dto.Order1Dto;
import com.cg.onlineshopping_application.util.FixedValues;

@Service
public class IOrderServiceImp implements IOrderService
{
	@Autowired
	IOrderRepository orderDao;
	
	@Autowired
	ICartRepository cartDao;
	
	@Autowired
	IAddressRepository addressDao;
	
	@Autowired
	ICustomerRepository customerDao;
	
	@Override
	public Order1 addOrder(Order1Dto order1Dto) throws ValidateOrderException, CustomerNotFoundException, AddressNotFoundException, CartNotFoundException {
		
		
		validateOrder(order1Dto);
		Order1 order1 = new Order1();
		
		Optional<Customer> optCustomer = customerDao.findById(order1Dto.getCustomerId());
		if (!optCustomer.isPresent())
			throw new CustomerNotFoundException(FixedValues.CUSTOMER_NOT_FOUND);
		
		Optional<Cart> optCart = cartDao.findById(order1Dto.getCartId());
		if (!optCart.isPresent())
			throw new CartNotFoundException(FixedValues.CART_NOT_FOUND);
		
		Optional<Address> optAddress = addressDao.findById(order1Dto.getAddressId());
		if (!optAddress.isPresent())
			throw new AddressNotFoundException(FixedValues.ADDRESS_NOT_FOUND);
		
		
		
		order1.setOrdStatus(order1Dto.getOrdStatus());
		order1.setOrdDate(order1Dto.getOrdDate());
		order1.setCustomer(optCustomer.get());
		order1.setAddress(optAddress.get());
		order1.setCart(optCart.get());
		
		return orderDao.save(order1);
	}

	@Override
	public Order1 updateOrder(Order1Dto order1Dto) throws OrderIdException, ValidateOrderException, CustomerNotFoundException, AddressNotFoundException, CartNotFoundException {
		validateOrder(order1Dto);
		
		Optional<Order1> optorder = orderDao.findById(order1Dto.getOrdId());
		if (!optorder.isPresent())
			throw new OrderIdException(FixedValues.ORDER_NOT_FOUND);
		Optional<Cart> optCart = cartDao.findById(order1Dto.getCartId());
		if (!optCart.isPresent())
			throw new CartNotFoundException(FixedValues.CART_NOT_FOUND);
		
		Optional<Address> optAddress = addressDao.findById(order1Dto.getAddressId());
		if (!optAddress.isPresent())
			throw new AddressNotFoundException(FixedValues.ADDRESS_NOT_FOUND);
		
		Optional<Customer> optCustomer = customerDao.findById(order1Dto.getCustomerId());
		if (!optCustomer.isPresent())
			throw new CustomerNotFoundException(FixedValues.CUSTOMER_NOT_FOUND);
			
		Order1 order1 = optorder.get();
		
		order1.setOrdStatus(order1Dto.getOrdStatus());
		order1.setOrdDate(order1Dto.getOrdDate());
		order1.setCustomer(optCustomer.get());
		order1.setAddress(optAddress.get());
		order1.setCart(optCart.get());
		
		return orderDao.save(order1);
	}

	
	public boolean validateOrder(Order1Dto order1Dto) throws ValidateOrderException {
		if (!order1Dto.getOrdStatus().matches("[A-Za-z0-9]{1,100}")) {
			throw new ValidateOrderException(FixedValues.STATUS_CANNOT_BE_EMPTY);
		}
		
		return true;
	}
	
	
	@Override
	public boolean removeOrder(Integer ordId) throws OrderIdException {
		Optional<Order1> optorder = orderDao.findById(ordId);

		if (!optorder.isPresent()) {
			throw new OrderIdException(FixedValues.ORDER_NOT_FOUND);

		}
		orderDao.delete(optorder.get());
		return true;
	}

	@Override
	public Order1 viewOrder(Integer ordId) throws OrderIdException {
		Optional<Order1> optorder = orderDao.findById(ordId);
		if (!optorder.isPresent()) {
			throw new OrderIdException(FixedValues.ORDER_NOT_FOUND);

		}
		return optorder.get();	}

	@Override
	public List<Order1> viewAllOrdersByLocation(Integer addressId) throws AddressNotFoundException {
		List<Order1> orderlist = orderDao.findAll();
		Optional<Address> optAddress = addressDao.findById(addressId);
		if (!optAddress.isPresent())
			throw new AddressNotFoundException(FixedValues.ADDRESS_NOT_FOUND);
		orderlist.stream()
		.filter(p ->p.getAddress().getAddressId()==addressId)
		.collect(Collectors.toList()); 
		return orderlist;
	}

	@Override
	public List<Order1> viewAllOrderByCustomerId(Integer customerId) throws CustomerNotFoundException {
		List<Order1> orderlist = orderDao.findAll();
		Optional<Customer> optCustomer = customerDao.findById(customerId);
		if (!optCustomer.isPresent())
			throw new CustomerNotFoundException(FixedValues.CUSTOMER_NOT_FOUND);

		orderlist.stream()
		.filter(p ->p.getCustomer().getCustomerId()==customerId)
		.collect(Collectors.toList());
		return orderlist;
	}

}
package com.cg.Online_Shopping_application;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import com.cg.onlineshopping_application.exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineshopping_application.OnlineshoppingApplication;
import com.cg.onlineshopping_application.dto.Order1Dto;
import com.cg.onlineshopping_application.entity.Address;
import com.cg.onlineshopping_application.entity.Customer;
import com.cg.onlineshopping_application.entity.Order1;
import com.cg.onlineshopping_application.entity.Product;
import com.cg.onlineshopping_application.repository.IAddressRepository;
import com.cg.onlineshopping_application.repository.ICustomerRepository;
import com.cg.onlineshopping_application.repository.IOrderRepository;
import com.cg.onlineshopping_application.repository.IProductRepository;
import com.cg.onlineshopping_application.service.IOrderService;
import com.cg.onlineshopping_application.service.IOrderServiceImp;

@SpringBootTest(classes = OnlineshoppingApplication.class)
public class TestEditOrder {
	@Mock
	private IOrderRepository orderDao;
	
	@Mock
	private ICustomerRepository customerDao;
	
	@Mock
	private IProductRepository productDao;
	
	@Mock
	private IAddressRepository addressDao;
	
	@InjectMocks
	private IOrderService orderService = new IOrderServiceImp();
	
	@BeforeEach
	private void beforeEach() {
		when(orderDao.findById(1)).thenReturn(Optional.of(new Order1()));
		when(orderDao.findById(2)).thenReturn(Optional.empty());
		when(customerDao.findById(1)).thenReturn(Optional.of(new Customer()));
		when(customerDao.findById(2)).thenReturn(Optional.empty());
		when(productDao.findById(1)).thenReturn(Optional.of(new Product()));
		when(productDao.findById(2)).thenReturn(Optional.empty());
		when(addressDao.findById(1)).thenReturn(Optional.of(new Address()));
		when(addressDao.findById(2)).thenReturn(Optional.empty());
		when(orderDao.save(any(Order1.class))).thenReturn(new Order1());
	}
	
	@Test
	public void testEditOrder1() throws ValidateOrderException, CustomerNotFoundException, AddressNotFoundException, CartNotFoundException, OrderIdException, ProductNotFoundException {
		Order1Dto dto = new Order1Dto(1,"Confirmed",LocalDate.of(2021, 03, 02),1,1,1);
		assertNotNull(orderService.updateOrder(dto));
	}
	
	@Test
	public void testEditOrder2() throws OrderIdException, ValidateOrderException, CustomerNotFoundException, AddressNotFoundException, ProductNotFoundException, CartNotFoundException {
		Order1Dto dto = new Order1Dto(1,"",LocalDate.of(2021, 03, 02),1,1,1);
		assertThrows(ValidateOrderException.class,()->orderService.updateOrder(dto));
	}

	@Test
	public void testEditOrder3() throws OrderIdException, ValidateOrderException, CustomerNotFoundException, AddressNotFoundException, ProductNotFoundException, CartNotFoundException {
		Order1Dto dto = new Order1Dto(2,"Confirmed",LocalDate.of(2021, 03, 02),1,1,1);
		assertThrows(OrderIdException.class,()->orderService.updateOrder(dto));
	}
}
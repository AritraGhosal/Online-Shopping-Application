package com.cg.Online_Shopping_application;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

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
import com.cg.onlineshopping_application.exception.AddressNotFoundException;
import com.cg.onlineshopping_application.exception.CartNotFoundException;
import com.cg.onlineshopping_application.exception.CustomerNotFoundException;
import com.cg.onlineshopping_application.exception.ProductNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateOrderException;
import com.cg.onlineshopping_application.repository.IAddressRepository;
import com.cg.onlineshopping_application.repository.ICustomerRepository;
import com.cg.onlineshopping_application.repository.IOrderRepository;
import com.cg.onlineshopping_application.repository.IProductRepository;
import com.cg.onlineshopping_application.service.IOrderService;
import com.cg.onlineshopping_application.service.IOrderServiceImp;

@SpringBootTest(classes = OnlineshoppingApplication.class)
public class TestAddOrder {
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
		when(customerDao.findById(1)).thenReturn(Optional.of(new Customer()));
		when(customerDao.findById(2)).thenReturn(Optional.empty());
		when(productDao.findById(1)).thenReturn(Optional.of(new Product()));
		when(productDao.findById(2)).thenReturn(Optional.empty());
		when(addressDao.findById(1)).thenReturn(Optional.of(new Address()));
		when(addressDao.findById(2)).thenReturn(Optional.empty());
		when(orderDao.save(any(Order1.class))).thenReturn(new Order1());
	}
	
	@Test
	public void testAddOrder1() throws ValidateOrderException, CustomerNotFoundException, AddressNotFoundException, ProductNotFoundException, CartNotFoundException {
		Order1Dto dto = new Order1Dto("Confirmed",LocalDate.of(2021, 03, 02),1,1,3);
		assertNotNull(orderService.addOrder(dto));
	}
	
	@Test
	public void testAddOrder2() throws ValidateOrderException, CustomerNotFoundException, AddressNotFoundException, ProductNotFoundException {
		Order1Dto dto = new Order1Dto("",LocalDate.of(2021, 03, 02),1,1,1);
		assertThrows(ValidateOrderException.class,()->orderService.addOrder(dto));
	}
	
	@Test
	public void testAddOrder3() throws ValidateOrderException, CustomerNotFoundException, AddressNotFoundException, ProductNotFoundException {
		Order1Dto dto = new Order1Dto("Confirmed",LocalDate.of(2021, 03, 02),2,1,1);
		assertThrows(CustomerNotFoundException.class,()->orderService.addOrder(dto));
	}
	
	@Test
	public void testAddOrder4() throws ValidateOrderException, CustomerNotFoundException, AddressNotFoundException, ProductNotFoundException {
		Order1Dto dto = new Order1Dto("Confirmed",LocalDate.of(2021, 03, 02),1,1,1);
		assertThrows(AddressNotFoundException.class,()->orderService.addOrder(dto));
	}
	
	@Test
	public void testAddOrder5() throws ValidateOrderException, CustomerNotFoundException, AddressNotFoundException, ProductNotFoundException {
		Order1Dto dto = new Order1Dto("Confirmed",LocalDate.of(2021, 03, 02),1,1,2);
		assertThrows(ProductNotFoundException.class,()->orderService.addOrder(dto));
	}
}

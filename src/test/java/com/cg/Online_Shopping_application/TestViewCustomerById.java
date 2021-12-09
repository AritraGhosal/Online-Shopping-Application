package com.cg.Online_Shopping_application;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineshopping_application.OnlineshoppingApplication;
import com.cg.onlineshopping_application.exception.CustomerIdException;
import com.cg.onlineshopping_application.model.Customer;
import com.cg.onlineshopping_application.repository.ICustomerRepository;
import com.cg.onlineshopping_application.repository.ILoginRepository;
import com.cg.onlineshopping_application.service.ICustomerService;
import com.cg.onlineshopping_application.service.ICustomerServiceImp;


@SpringBootTest(classes = OnlineshoppingApplication.class)
public class TestViewCustomerById {
	@Mock
	private ICustomerRepository customerDao;
	
	@Mock
	private ILoginRepository userDao;
	
	@InjectMocks
	private ICustomerService customerService = new ICustomerServiceImp();
	
	@BeforeEach
	public void beforeEach() {
		when(customerDao.findById(1)).thenReturn(Optional.of(new Customer()));
		when(customerDao.findById(2)).thenReturn(Optional.empty());
	}
	
	@Test
	public void testViewCustomerById() throws CustomerIdException {
		assertNotNull(customerService.viewCustomerById(1));
	}
	
	@Test
	public void testViewAddressById2() throws CustomerIdException {
		assertThrows(CustomerIdException.class,()->customerService.viewCustomerById(2));
	}
}



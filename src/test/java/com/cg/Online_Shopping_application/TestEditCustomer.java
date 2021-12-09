package com.cg.Online_Shopping_application;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineshopping_application.OnlineshoppingApplication;
import com.cg.onlineshopping_application.dto.CustomerDto;
import com.cg.onlineshopping_application.exception.CustomerIdException;
import com.cg.onlineshopping_application.exception.UserNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateCustomerException;
import com.cg.onlineshopping_application.model.Customer;
import com.cg.onlineshopping_application.model.User;
import com.cg.onlineshopping_application.repository.ICustomerRepository;
import com.cg.onlineshopping_application.repository.ILoginRepository;
import com.cg.onlineshopping_application.service.ICustomerService;
import com.cg.onlineshopping_application.service.ICustomerServiceImp;



@SpringBootTest(classes = OnlineshoppingApplication.class)
public class TestEditCustomer {
	@Mock
	private ICustomerRepository customerDao;
	
	@Mock
	private ILoginRepository loginDao;
	
	@InjectMocks
	private ICustomerService customerService = new ICustomerServiceImp();

	@BeforeEach
	public void beforeEach() {
		when(loginDao.findById(1)).thenReturn(Optional.of(new User()));
		when(loginDao.findById(2)).thenReturn(Optional.empty());
		when(customerDao.save(any(Customer.class))).thenReturn(new Customer());
		when(customerDao.findById(1)).thenReturn(Optional.of(new Customer()));
		when(customerDao.findById(2)).thenReturn(Optional.empty());
	}
	
	@Test
	public void testEditCustomer1() throws CustomerIdException, ValidateCustomerException, UserNotFoundException {
		CustomerDto dto = new CustomerDto(1,"sayanipa","boseee","8855664477","boserocks@gmail.com",1);
		
		assertNotNull(customerService.updateCustomer(dto));
		
	}
	
	@Test
	public void testEditCustomer2() throws CustomerIdException, ValidateCustomerException, UserNotFoundException {
		CustomerDto dto = new CustomerDto(2,"sayanipa","bose","8855664477","boserocks@gmail.com",1);
		
		assertThrows(CustomerIdException.class,()->customerService.updateCustomer(dto));
		
	}
	
	@Test
	public void testEditCustomer3() throws CustomerIdException, ValidateCustomerException, UserNotFoundException {
		CustomerDto dto = new CustomerDto(1,"sayanipa","bose","8855664477","boserocks@gmail.com",2);
		
		assertThrows(UserNotFoundException.class,()->customerService.updateCustomer(dto));
		
	}
	
	@Test
	public void testEditCustomer4() throws CustomerIdException, ValidateCustomerException, UserNotFoundException {
		CustomerDto dto = new CustomerDto(1,"sayanipa","bose12","8855664477","boserocks@gmail.com",1);
		
		assertThrows(ValidateCustomerException.class,()->customerService.updateCustomer(dto));
		
	}
	
	@Test
	public void testEditCustomer5() throws CustomerIdException, ValidateCustomerException, UserNotFoundException {
		CustomerDto dto = new CustomerDto(1,"sayanipa","bose","885566447733","boserocks@gmail.com",1);
		
		assertThrows(ValidateCustomerException.class,()->customerService.updateCustomer(dto));
		
	}
	
	@Test
	public void testEditCustomer6() throws CustomerIdException, ValidateCustomerException, UserNotFoundException {
		CustomerDto dto = new CustomerDto(1,"sayanipa","bose","8855664477","boserocks/gmail.com",1);
		
		assertThrows(ValidateCustomerException.class,()->customerService.updateCustomer(dto));
		
	}
}

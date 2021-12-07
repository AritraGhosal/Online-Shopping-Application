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
import com.cg.onlineshopping_application.entity.Customer;
import com.cg.onlineshopping_application.entity.User;
import com.cg.onlineshopping_application.exception.CustomerIdException;
import com.cg.onlineshopping_application.exception.UserNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateCustomerException;
import com.cg.onlineshopping_application.repository.ICustomerRepository;
import com.cg.onlineshopping_application.repository.ILoginRepository;
import com.cg.onlineshopping_application.service.ICustomerService;
import com.cg.onlineshopping_application.service.ICustomerServiceImp;



@SpringBootTest(classes = OnlineshoppingApplication.class)
public class TestAddCustomer {

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
	}
	
	@Test
	public void testAddCustomerById1() throws CustomerIdException, ValidateCustomerException, UserNotFoundException{
		CustomerDto dto = new CustomerDto("sayanipa","bose","8855664477","boserocks@gmail.com",1);
		
		assertNotNull(customerService.addCustomer(dto));
	}
	
	@Test
	public void testAddCustomerById2() throws CustomerIdException, ValidateCustomerException, UserNotFoundException{
		CustomerDto dto = new CustomerDto("sayanipa","bose","8855664477","boserocks@gmail.com",2);
		
		assertThrows(UserNotFoundException.class,()->customerService.addCustomer(dto));
	}
	
	@Test
	public void testAddCustomerById3() throws CustomerIdException, ValidateCustomerException, UserNotFoundException{
		CustomerDto dto = new CustomerDto("sayanipa12","bose","8855664477","boserocks@gmail.com",1);
		
		assertThrows(ValidateCustomerException.class,()->customerService.addCustomer(dto));
	}
	
	@Test
	public void testViewCustomerById4() throws CustomerIdException, ValidateCustomerException, UserNotFoundException{
		CustomerDto dto = new CustomerDto("sayanipa","bose","885566447733","boserocks@gmail.com",1);
		
		assertThrows(ValidateCustomerException.class,()->customerService.addCustomer(dto));
	}
	
	@Test
	public void testViewCustomerById5() throws CustomerIdException, ValidateCustomerException, UserNotFoundException{
		CustomerDto dto = new CustomerDto("sayanipa","bose","885566447733","boserocks/gmail.com",1);
		
		assertThrows(ValidateCustomerException.class,()->customerService.addCustomer(dto));
	}
}


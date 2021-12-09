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
import com.cg.onlineshopping_application.dto.AddressDto;
import com.cg.onlineshopping_application.exception.AddressIdException;
import com.cg.onlineshopping_application.exception.CustomerNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateAddressException;
import com.cg.onlineshopping_application.model.Address;
import com.cg.onlineshopping_application.model.Customer;
import com.cg.onlineshopping_application.repository.IAddressRepository;
import com.cg.onlineshopping_application.repository.ICustomerRepository;
import com.cg.onlineshopping_application.service.IAddressService;
import com.cg.onlineshopping_application.service.IAddressServiceImp;

@SpringBootTest(classes = OnlineshoppingApplication.class)
public class TestAddAddress {
	@Mock
	private ICustomerRepository customerDao;
	
	@Mock
	private IAddressRepository addressDao;
	
	@InjectMocks
	private IAddressService addressService = new IAddressServiceImp();
	
	@BeforeEach
	public void berforeEach() {
		when(customerDao.findById(1)).thenReturn(Optional.of(new Customer()));
		when(customerDao.findById(2)).thenReturn(Optional.empty());
		when(addressDao.save(any(Address.class))).thenReturn(new Address());
	}
	
	@Test
	public void testViewAddressById() throws AddressIdException, ValidateAddressException, CustomerNotFoundException {
		AddressDto dto = new AddressDto(1,"13c","gt road","betapark","kolkata","westbengal","700017");
		
		assertNotNull(addressService.addAddress(dto));
		
	}
	
	@Test
 void testViewAddressById2() throws AddressIdException, ValidateAddressException, CustomerNotFoundException {
		
		AddressDto dto = new AddressDto(2,"13c","gt road","betapark","kolkata","westbengal","700017");
		assertThrows(CustomerNotFoundException.class,()-> addressService.addAddress(dto));
		
	}
	
	@Test
	public void testViewAddressById3() throws AddressIdException, ValidateAddressException, CustomerNotFoundException {
		
		AddressDto dto = new AddressDto(1,"13yeyeyeyeyeye","gt road","betapark","kolkata","westbengal","700017");
		assertThrows(ValidateAddressException.class,()-> addressService.addAddress(dto));
		
	}
	
	@Test
	public void testViewAddressById4() throws AddressIdException, ValidateAddressException, CustomerNotFoundException {
		
		AddressDto dto = new AddressDto(1,"13c","gt road123","betapark","kolkata","westbengal","700017");
		assertThrows(ValidateAddressException.class,()-> addressService.addAddress(dto));
		
	}
	
	@Test
	public void testViewAddressById5() throws AddressIdException, ValidateAddressException, CustomerNotFoundException {
		
		AddressDto dto = new AddressDto(1,"13c","gt road","betapark","kolkata","westbengal","000017");
		assertThrows(ValidateAddressException.class,()-> addressService.addAddress(dto));
		
	}
	
	@Test
	public void testViewAddressById6() throws AddressIdException, ValidateAddressException, CustomerNotFoundException {
		
		AddressDto dto = new AddressDto(1,"13c","gt road","betapark","kolkata","westbengal","1");
		assertThrows(ValidateAddressException.class,()-> addressService.addAddress(dto));
		
	}
}



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

import com.cg.onlineshopping_application.entity.Address;
import com.cg.onlineshopping_application.exception.AddressIdException;
import com.cg.onlineshopping_application.repository.IAddressRepository;
import com.cg.onlineshopping_application.repository.ICustomerRepository;
import com.cg.onlineshopping_application.service.IAddressService;
import com.cg.onlineshopping_application.service.IAddressServiceImp;



@SpringBootTest
class TestViewAddressById {
	@Mock
	private ICustomerRepository customerDao;
	
	@Mock
	private IAddressRepository addressDao;
	
	@InjectMocks
	private IAddressService addressService = new IAddressServiceImp();
	
	@BeforeEach
	protected void berforeEach() {
		when(addressDao.findById(1)).thenReturn(Optional.of(new Address()));
		when(addressDao.findById(2)).thenReturn(Optional.empty());
	}
	
	@Test
	protected void testViewAddressById() throws AddressIdException {
		assertNotNull(addressService.viewAddress(1));
	}
	
	@Test
	protected void testViewAddressById2() throws AddressIdException {
		assertThrows(AddressIdException.class,()->addressService.viewAddress(2));
	}
	
	
	
}










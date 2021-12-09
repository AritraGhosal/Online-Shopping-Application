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
import com.cg.onlineshopping_application.exception.OrderIdException;
import com.cg.onlineshopping_application.model.Order1;
import com.cg.onlineshopping_application.repository.IOrderRepository;
import com.cg.onlineshopping_application.service.IOrderService;
import com.cg.onlineshopping_application.service.IOrderServiceImp;

@SpringBootTest(classes = OnlineshoppingApplication.class)
public class TestViewOrderById {
	@Mock
	private IOrderRepository orderDao;
	
	@InjectMocks
	private IOrderService orderService = new IOrderServiceImp();
	
	@BeforeEach
	public void beforeEach() {
		when(orderDao.findById(1)).thenReturn(Optional.of(new Order1()));
		when(orderDao.findById(2)).thenReturn(Optional.empty());
	}
	
	@Test
	public void testViewOrderById1() throws OrderIdException {
		assertNotNull(orderService.viewOrder(1));
	}
	
	@Test
	public void testViewOrderById2() throws OrderIdException {
		assertThrows(OrderIdException.class,()->orderService.viewOrder(2));
	}
}
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
import com.cg.onlineshopping_application.entity.Product;
import com.cg.onlineshopping_application.exception.ProductIdException;
import com.cg.onlineshopping_application.exception.ValidateProductException;
import com.cg.onlineshopping_application.repository.IProductRepository;
import com.cg.onlineshopping_application.service.IProductService;
import com.cg.onlineshopping_application.service.IProductServiceImp;

@SpringBootTest(classes = OnlineshoppingApplication.class)
public class TestViewProductById {
	@Mock
	private IProductRepository productDao;
	
	@InjectMocks
	private IProductService productService = new IProductServiceImp();
	
	@BeforeEach
	public void beforeEach() {
		when(productDao.findById(1)).thenReturn(Optional.of(new Product()));
		when(productDao.findById(2)).thenReturn(Optional.empty());
	}
	
	@Test
	public void testViewProductById1() throws ValidateProductException {
		assertNotNull(productService.viewProduct("1"));
	}
	
	@Test
	public void testViewProductById2() throws ProductIdException {
		assertThrows(ProductIdException.class,()->productService.viewProduct("2"));
	}
}
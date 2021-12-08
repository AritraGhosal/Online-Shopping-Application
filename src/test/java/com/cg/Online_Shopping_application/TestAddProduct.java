 package com.cg.Online_Shopping_application;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineshopping_application.OnlineshoppingApplication;
import com.cg.onlineshopping_application.dto.ProductDto;
import com.cg.onlineshopping_application.entity.Category;
import com.cg.onlineshopping_application.entity.Product;
import com.cg.onlineshopping_application.exception.CategoryNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateProductException;
import com.cg.onlineshopping_application.repository.ICategoryRepository;
import com.cg.onlineshopping_application.repository.IProductRepository;
import com.cg.onlineshopping_application.service.IProductService;
import com.cg.onlineshopping_application.service.IProductServiceImp;

@SpringBootTest(classes = OnlineshoppingApplication.class)
public class TestAddProduct {
	@Mock
	private ICategoryRepository categoryDao;
	
	@Mock
	private IProductRepository productDao;	
	
	@InjectMocks
	private IProductService productService = new IProductServiceImp();
	
	@BeforeEach
	public void beforeEach() {
		when(categoryDao.findById(1)).thenReturn(Optional.of(new Category()));
		when(categoryDao.findById(2)).thenReturn(Optional.empty());
		when(productDao.save(any(Product.class))).thenReturn(new Product());
	}
	
	@Test
	public void addProduct1() throws ValidateProductException, CategoryNotFoundException {
		ProductDto dto = new ProductDto("iphone",10000.00,"gold","13x13x3","A14","Apple",10,1);
	
		assertNotNull(productService.addProduct(dto));
	}

	@Test
	public void addProduct2() throws ValidateProductException, CategoryNotFoundException {
		ProductDto dto = new ProductDto("iphone",10000.00,"gold","13x13x3","A14","Apple",10,2);
	
		assertThrows(NoSuchElementException.class,()->productService.addProduct(dto));
	}
	
	@Test
	public void addProduct3() throws ValidateProductException, CategoryNotFoundException {
		ProductDto dto = new ProductDto("iphone",0,"gold","13x13x3","A14","Apple",10,1);
	
		assertThrows(ValidateProductException.class,()->productService.addProduct(dto));
	}
}
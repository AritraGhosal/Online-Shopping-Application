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
import com.cg.onlineshopping_application.dto.ProductDto;
import com.cg.onlineshopping_application.exception.CategoryNotFoundException;
import com.cg.onlineshopping_application.exception.ProductIdException;
import com.cg.onlineshopping_application.exception.ProductNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateProductException;
import com.cg.onlineshopping_application.model.Category;
import com.cg.onlineshopping_application.model.Product;
import com.cg.onlineshopping_application.repository.ICategoryRepository;
import com.cg.onlineshopping_application.repository.IProductRepository;
import com.cg.onlineshopping_application.service.IProductService;
import com.cg.onlineshopping_application.service.IProductServiceImp;

@SpringBootTest(classes = OnlineshoppingApplication.class)
public class TestEditProduct {
	@Mock
	private IProductRepository productDao;
	
	@Mock
	private ICategoryRepository categoryDao;
	
	@InjectMocks
	private IProductService productService = new IProductServiceImp();
	
	@BeforeEach
	public void beforeEach() {
		when(productDao.findById(1)).thenReturn(Optional.of(new Product()));
		when(productDao.findById(2)).thenReturn(Optional.empty());
		when(productDao.save(any(Product.class))).thenReturn(new Product());
		when(categoryDao.findById(1)).thenReturn(Optional.of(new Category()));
		when(categoryDao.findById(2)).thenReturn(Optional.empty());
	}
	
	@Test
	public void testEditProduct1() throws ValidateProductException, CategoryNotFoundException, ProductNotFoundException, ProductIdException {
		ProductDto dto = new ProductDto(1,"iphone12",10000.00,"black","34x12x3","A14","apple",12,1);
		assertNotNull(productService.updateProduct(dto));
	}
}
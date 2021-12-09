package com.cg.onlineshopping_application.service;

import java.util.List;

import com.cg.onlineshopping_application.dto.ProductDto;
import com.cg.onlineshopping_application.exception.CategoryNotFoundException;
import com.cg.onlineshopping_application.exception.ProductIdException;
import com.cg.onlineshopping_application.exception.ValidateProductException;
import com.cg.onlineshopping_application.model.Product;

public interface IProductService {
 public List<Product> viewAllProducts() throws ValidateProductException;
 public Product addProduct(ProductDto productDto) throws ValidateProductException;
 public Product updateProduct(ProductDto productDto) throws  ValidateProductException;
 public Product viewProduct(String productName) throws ValidateProductException;
 public List<Product> viewProductsByCategory(Integer cat) throws ValidateProductException; 
 public boolean removeProduct(Integer productId) throws ValidateProductException;
}
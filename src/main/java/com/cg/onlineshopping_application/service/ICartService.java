package com.cg.onlineshopping_application.service;

import java.util.List;

import com.cg.onlineshopping_application.entity.Cart;
import com.cg.onlineshopping_application.exception.CustomerNotFoundException;
import com.cg.onlineshopping_application.exception.ProductNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateCartException;



public interface ICartService {

	public Cart addProductToCart(Integer customerId, Integer productId) throws CustomerNotFoundException, ProductNotFoundException;
	public boolean removeProductFromCart(Integer cartItemId) throws ValidateCartException;
	public List<Cart> viewAllProductsInCart(Integer customerId) throws ValidateCartException,CustomerNotFoundException;
}

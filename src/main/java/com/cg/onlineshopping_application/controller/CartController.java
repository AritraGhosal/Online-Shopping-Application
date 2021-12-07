package com.cg.onlineshopping_application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.onlineshopping_application.dto.SuccessMessageDto;
import com.cg.onlineshopping_application.entity.Cart;
import com.cg.onlineshopping_application.exception.CustomerNotFoundException;
import com.cg.onlineshopping_application.exception.ProductNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateCartException;
import com.cg.onlineshopping_application.service.ICartService;
import com.cg.onlineshopping_application.util.ShoppingConstants;


@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private ICartService cartService;
	
	@GetMapping("addcart/{customerId}/{productId}")
	public SuccessMessageDto addItemToCart(@PathVariable("customerId") Integer customerId,@PathVariable("productId") Integer productId) throws CustomerNotFoundException, ProductNotFoundException
	{
		cartService.addProductToCart(customerId,productId);
		
		return new SuccessMessageDto(ShoppingConstants.CART_ITEM_ADDED);
	}
	
	@GetMapping("getcartitems/{customerId}")
	public List<Cart> getCartItems(@PathVariable("customerId") Integer customerId) throws ValidateCartException, CustomerNotFoundException
	{
		return cartService.viewAllProductsInCart(customerId);
	}

	@DeleteMapping("removecartitem/{cartId}")
	public SuccessMessageDto removeCartItem(@PathVariable("cartId") Integer cartId) {
		
		cartService.removeProductFromCart(cartId);
		return new SuccessMessageDto(ShoppingConstants.CART_ITEM_REMOVED);
	}
}

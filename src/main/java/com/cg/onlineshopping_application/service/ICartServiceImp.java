package com.cg.onlineshopping_application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping_application.exception.CustomerNotFoundException;
import com.cg.onlineshopping_application.exception.ProductNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateCartException;
import com.cg.onlineshopping_application.exception.ValidateProductException;
import com.cg.onlineshopping_application.model.Cart;
import com.cg.onlineshopping_application.model.Customer;
import com.cg.onlineshopping_application.model.Product;
import com.cg.onlineshopping_application.repository.ICartRepository;
import com.cg.onlineshopping_application.repository.ICustomerRepository;
import com.cg.onlineshopping_application.repository.IProductRepository;
import com.cg.onlineshopping_application.util.FixedValues;

@Service
public class ICartServiceImp implements ICartService
{
	@Autowired
	private ICartRepository cartRepo;
	
	@Autowired
	private ICustomerRepository custRepo;
	
	@Autowired
	private IProductRepository productRepo;
	
	@Override
	public Cart addProductToCart(Integer customerId, Integer productId) throws CustomerNotFoundException, ProductNotFoundException {
		Optional<Customer> optCustomer=custRepo.findById(customerId);
		if(optCustomer.isEmpty())
			throw new CustomerNotFoundException(FixedValues.CUSTOMER_NOT_FOUND);
		Optional<Product> optProduct= productRepo.findById(productId);
		if(optProduct.isEmpty())
			throw new ProductNotFoundException(FixedValues.PRODUCT_NOT_FOUND);
		
		Product product =optProduct.get();
		
		if(product.getQuantity()<=0)
			throw new ValidateProductException(FixedValues.NO_STOCK);
		
		Cart cart= new Cart();
		cart.setCustomer(optCustomer.get());
		
		cart.setProduct(product);
		
		Cart item= cartRepo.save(cart);
		return item;
	}

	@Override
	public boolean removeProductFromCart(Integer cartItemId) throws ValidateCartException {
		
		Optional<Cart> optCart= cartRepo.findById(cartItemId);
		
		if(optCart.isEmpty())
			throw new ValidateCartException(FixedValues.CART_ITEM_NOT_FOUND);
		
		cartRepo.delete(optCart.get());
		return true;
	}

	@Override
	public List<Cart> viewAllProductsInCart(Integer customerId)
			throws ValidateCartException, CustomerNotFoundException {
		
		Optional<Customer> optCustomer=custRepo.findById(customerId);
		if(optCustomer.isEmpty())
			throw new CustomerNotFoundException(FixedValues.CUSTOMER_NOT_FOUND);
		
		List<Cart> cartList= cartRepo.getCartItems(customerId);
		
		if(cartList.isEmpty())
			throw new ValidateCartException(FixedValues.CART_EMPTY);
		
		return cartList;
	}



}

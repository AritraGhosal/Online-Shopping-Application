package com.cg.onlineshopping_application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="cart_item")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	
	@ManyToOne
	private Product product;
	
	@ManyToOne
	private Customer customer;
	
	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


}

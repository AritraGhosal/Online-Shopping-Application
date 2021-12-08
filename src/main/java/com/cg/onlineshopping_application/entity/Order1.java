package com.cg.onlineshopping_application.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Order1 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ordId;
	@NotBlank
	private String ordStatus;
	@NotBlank
	private LocalDate ordDate;
	
	@OneToOne
	@JsonIgnore
	@NotBlank
	private Customer customer;
	
	
	@OneToOne
	@JsonIgnore
	@NotBlank
	private Address address;

	@OneToOne
	@JsonIgnore
	@NotBlank
	private Cart cart;


	public Integer getOrdId() {
		return ordId;
	}

	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
	}

	public String getOrdStatus() {
		return ordStatus;
	}

	public void setOrdStatus(String ordStatus) {
		this.ordStatus = ordStatus;
	}

	public LocalDate getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(LocalDate ordDate) {
		this.ordDate = ordDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}



}

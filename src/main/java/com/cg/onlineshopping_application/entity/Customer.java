package com.cg.onlineshopping_application.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customers")
public class Customer 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String email;
	
	@OneToOne
	private User user;
	
	@JsonIgnore
	@OneToOne(mappedBy="customer")
	private Address address;
	

	@JsonIgnore
	@OneToOne(mappedBy="customer")
	private Order1 ord;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	public Order1 getOrd() {
		return ord;
	}

	public void setOrd(Order1 ord) {
		this.ord = ord;
	}
	
}

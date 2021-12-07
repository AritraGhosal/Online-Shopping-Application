package com.cg.onlineshopping_application.dto;

public class CustomerDto {
	
	private Integer customerId;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String email;
	private Integer userId;
	
	public CustomerDto() {
		super();
		
	}

	public CustomerDto(Integer customerId, String firstName, String lastName, String mobileNumber, String email, Integer userId) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.userId= userId;
	}

	public CustomerDto(String firstName, String lastName, String mobileNumber, String email, Integer userId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.userId= userId;
	}

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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	

}

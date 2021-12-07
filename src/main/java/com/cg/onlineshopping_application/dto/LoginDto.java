package com.cg.onlineshopping_application.dto;

public class LoginDto {

	private Integer userId;
	private String userEmail;
	private String password;
	private String role;
	
	public LoginDto() {
		super();
	}
	
	
	public LoginDto(Integer userId,String userEmail, String password, String role) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.password = password;
		this.role = role;
	}
	
	
	public LoginDto(String userEmail, String password, String role) {
		super();
		this.userEmail=userEmail;
		this.password = password;
		this.role = role;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}

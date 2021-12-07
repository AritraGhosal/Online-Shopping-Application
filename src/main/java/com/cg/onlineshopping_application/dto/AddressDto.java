package com.cg.onlineshopping_application.dto;

public class AddressDto 
{
	private Integer customerId;
	private String streetNo;
	private String buildingName;
	private String city;
	private String state;
	private String country;	
	private String pincode;
	private Integer addressId;
	
	public AddressDto() {
		super();
	}
	
	public AddressDto(Integer customerId, String streetNo, String buildingName, String city, String state,
			String country, String pincode, Integer addressId) {
		super();
		this.customerId = customerId;
		this.streetNo = streetNo;
		this.buildingName = buildingName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.addressId = addressId;
	}
	
	
	public AddressDto(Integer customerId, String streetNo, String buildingName, String city, String state,
			String country, String pincode) {
		super();
		this.customerId = customerId;
		this.streetNo = streetNo;
		this.buildingName = buildingName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public String getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	
	

}

package com.cg.onlineshopping_application.dto;

public class ProductDto {

	private Integer productId;
	private String productName;
	private double price;
	private String color;
	private String dimension;
	private String specification;
	private String manufacturer;
	private int quantity;
    private Integer catId;
   
	public ProductDto() {
		super();
	}
	public ProductDto(Integer productId, String productName, double price, String color, String dimension,
			String specification, String manufacturer, int quantity, Integer categoryId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.dimension = dimension;
		this.specification = specification;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.catId = categoryId;
	}
	public ProductDto(String productName, double price, String color, String dimension, String specification,
			String manufacturer, int quantity, Integer categoryId) {
		super();
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.dimension = dimension;
		this.specification = specification;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.catId = categoryId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Integer getCatId() {
		return catId;
	}
	public void setCategoryId(Integer categoryId) {
		this.catId = categoryId;
	}
	
}

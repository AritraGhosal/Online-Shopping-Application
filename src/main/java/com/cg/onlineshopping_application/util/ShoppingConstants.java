package com.cg.onlineshopping_application.util;

public class ShoppingConstants {
	
	ShoppingConstants(){}
	
	public static final String ADDRESS_NOT_FOUND="Address not found!";
	public static final String ADDRESS_UPDATED="Address updated successfully for the ID ";
	
	public static final String USER_NOT_FOUND="User not found!";
	public static final String STREET_CANNOT_BE_EMPTY="Street Number cannot be empty and contains alphanumeric contains maximum of 3 charecters";
	public static final String BUILDING_CANNOT_BE_EMPTY="Building name must contain only alphabets and one space can be allowed";
	public static final String STATE_CANNOT_BE_EMPTY="State name must contain only alphabets";
	public static final String COUNTRY_CANNOT_BE_EMPTY="Country came cannot be empty and contains alphabets only";
	public static final String PINCODE_CANNOT_BE_EMPTY="Pincode must contain 6 digits";
	public static final String CITY_CANNOT_BE_EMPTY="City must contain only alphabets";
	public static final String ADDRESS_ADDED="Address added successfully and Generated ID is ";
	public static final String ADDRESS_REMOVED="Address removed successfully";
	public static final String ADDRESS_PATTERN = "([a-zA-Z]+|[A-Za-z]+[ ]{1}[a-zA-Z]+)";
	
	public static final String CUSTOMER_PATTERN = "([a-zA-Z]+|[A-Za-z]+[ ]{1}[a-zA-Z]+)";
	public static final String CUSTOMER_CANNOT_BE_EMPTY="Customer name must contain only alphabets";
	public static final String PHONENUMBER_CANNOT_BE_EMPTY="Phone number must contain 10 digits";
	public static final String EMAIL_CANNOT_BE_EMPTY="Enter a valid Email-Id";
	public static final String CUSTOMER_ADDED ="CUSTOMER added successfully and Generated ID is ";
	public static final String CUSTOMER_NOT_FOUND="Customer not found!";
	public static final String CUSTOMER_UPDATED="Customer updated successfully for the ID ";
	public static final String CUSTOMER_REMOVED="Customer removed successfully";
	
	public static final String USEREMAIL_CANNOT_BE_EMPTY="Enter a valid User-Email Example: example@example.com";
	public static final String PASSWORD_NOT_STRONG="Password should contain atleast one uppercase alphatbet, one lowercase alphabet, one digit, one special character. Min size:8, Max Size:32";
	public static final String USEREMAIL_PATTERN="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	public static final String PASSWORD_PATTERN="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
	public static final String ROLE_INVALID="INVALID ROLE! Enter: ADMIN or USER";
	public static final String USER_ADDED="User added successfully and ID is ";
	public static final String USER_REMOVED="User removed successfully";
	
	
	public static final String PRODUCT_NOT_FOUND="Products not found in the list!";
	public static final String CATEGORY_NOT_FOUND="Category not found in the list!";
	public static final String PRODUCT_PATTERN = "([a-zA-Z]+|[A-Za-z]+[ ]{1}[a-zA-Z]+)";
	public static final String PRODUCT_CANNOT_BE_EMPTY="Product cannot be empty";
	public static final String PRICE_CANNOT_BE_EMPTY="Price cannot be zero or negative";
	public static final String COLOR_CANNOT_BE_EMPTY="Color cannot be blank";
	public static final String DIMENSION_CANNOT_BE_EMPTY="Dimensions cannot be empty";
	public static final String SPECIFICATION_CANNOT_BE_EMPTY="Specifications cannot be empty";
	public static final String MANUFACTURER_CANNOT_BE_EMPTY="Manufacturer cannot be empty";
	public static final String QUANTITY_CANNOT_BE_EMPTY="Quantity cannot be less than zero or zero";
	public static final String PRODUCT_ADDED="Product added successfully and Generated ID is ";
	public static final String PRODUCT_REMOVED="Product removed successfully";
	public static final String PRODUCT_UPDATED="Product updated successfully for the ID ";
	public static final String NO_STOCK="No Stock Available";
	
    public static final String ORDER_NOT_FOUND="Order is not found!";
    public static final String STATUS_CANNOT_BE_EMPTY="Order status cannot be empty!";
    public static final String ORDER_ADDED="ORDER added successfully and Generated ID is ";
    public static final String ORDER_UPDATED="Order updated successfully for the ID ";
    public static final String ORDER_REMOVED="Order removed successfully";
    
    public static final String CATEGORY_CANNOT_BE_EMPTY="Category name cannot be empty!";
    public static final String CATEGORY_ADDED="Category added successfully and Generated ID is ";
    public static final String CATEGORY_UPDATED="Category updated successfully for the ID ";
    
    public static final String CART_EMPTY="No items in the cart";
    public static final String CART_ITEM_NOT_FOUND="Cart Item not found";
	public static final String CART_NOT_FOUND="Cart not found";
    public static final String CART_ITEM_ADDED="Cart item added ";
    public static final String CART_ITEM_REMOVED="Cart Item Removed";
    
}

package com.cg.onlineshopping_application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping_application.dto.CustomerDto;
import com.cg.onlineshopping_application.dto.SuccessMessageDto;
import com.cg.onlineshopping_application.exception.CustomerIdException;
import com.cg.onlineshopping_application.exception.UserNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateCustomerException;
import com.cg.onlineshopping_application.model.Customer;
import com.cg.onlineshopping_application.model.Product;
import com.cg.onlineshopping_application.service.ICustomerServiceImp;
import com.cg.onlineshopping_application.util.FixedValues;

@RestController
@RequestMapping("/customer")
public class CustomerController 
{
    
        @Autowired
        ICustomerServiceImp customerService;
        
        
        @PostMapping("/addcustomer")
        public SuccessMessageDto addCustomer(@RequestBody CustomerDto customerDto) throws ValidateCustomerException, UserNotFoundException
        {
            Customer customer= customerService.addCustomer(customerDto);
            return new SuccessMessageDto(FixedValues.CUSTOMER_ADDED+ customer.getCustomerId());
        }
        
        @DeleteMapping("/removecustomer/{id}")
        public SuccessMessageDto removeCustomer(@PathVariable("id") Integer id) throws CustomerIdException
        {
            customerService.removeCustomer(id);
            return new SuccessMessageDto(FixedValues.CUSTOMER_REMOVED);
        }
        
        @PutMapping("/updatecustomer")
        public SuccessMessageDto updateCustomer(@RequestBody CustomerDto add) throws CustomerIdException, ValidateCustomerException, UserNotFoundException 
        {
            Customer customer=customerService.updateCustomer(add);
            return new SuccessMessageDto(FixedValues.CUSTOMER_UPDATED+customer.getCustomerId());
        }
        
        @GetMapping("/getcustomerbyid/{customerId}")
        public Customer viewCustomerById(@PathVariable("customerId")Integer customerId) throws CustomerIdException 
        {
        
            return customerService.viewCustomerById(customerId); 
        }
        
        @GetMapping("/getallcustomer")
        public List<Customer> viewCustomer() throws CustomerIdException 
        {
            return customerService.viewAllCustomers();    
        }
        
        @GetMapping("/getcustomerdata/{userId}")
        public Customer getCustomerData(@PathVariable("userId") Integer userId) {
            Customer customer = customerService.getCustomerData(userId);
            return customer;
        }

}
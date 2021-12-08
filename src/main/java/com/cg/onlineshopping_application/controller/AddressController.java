package com.cg.onlineshopping_application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping_application.dto.AddressDto;
import com.cg.onlineshopping_application.dto.SuccessMessageDto;
import com.cg.onlineshopping_application.entity.Address;
import com.cg.onlineshopping_application.entity.Customer;
import com.cg.onlineshopping_application.exception.AddressIdException;
import com.cg.onlineshopping_application.exception.CustomerNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateAddressException;
import com.cg.onlineshopping_application.service.IAddressServiceImp;
import com.cg.onlineshopping_application.util.ShoppingConstants;



@RestController
@RequestMapping("/address")
//@CrossOrigin
public class AddressController 
{
    @Autowired
    IAddressServiceImp addressService;
    
    
    @PostMapping("/addaddress")
    public Address addAddress(@RequestBody AddressDto addressDto) throws ValidateAddressException, CustomerNotFoundException
    {
        Address address= addressService.addAddress(addressDto);
        return address;
    }
    
    @DeleteMapping("/removeaddress/{id}")
    public SuccessMessageDto removeAddress(@PathVariable("id") Integer addressId) throws AddressIdException
    {
        addressService.removeAddress(addressId);
        return new SuccessMessageDto(ShoppingConstants.ADDRESS_REMOVED);
    }
    
    @PutMapping("/updateaddress")
    public SuccessMessageDto updateAddress(@RequestBody AddressDto addressdto) throws AddressIdException, ValidateAddressException, CustomerNotFoundException 
    {
        Address address=addressService.updateAddress(addressdto);
        return new SuccessMessageDto(ShoppingConstants.ADDRESS_UPDATED+address.getAddressId());
    }
    
    @GetMapping("/getaddressbyid/{customerId}")
    public Address viewAddressById(@PathVariable("customerId")Integer id) throws AddressIdException 
    {
    
        return addressService.viewAddress(id);    
    }
    
    @GetMapping("/getalladdress")
    public List<Address> viewAddress() throws AddressIdException 
    {
        return addressService.viewAllAddress();    
    }
    
    /*@GetMapping("/getaddressdata/{customerId}")
    public Address getAddressData(@PathVariable("customerId") Integer customerId) {
        Address address = addressService.getAddressData(customerId);
        return address;
    }*/
}
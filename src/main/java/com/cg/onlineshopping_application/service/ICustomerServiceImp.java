package com.cg.onlineshopping_application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping_application.dto.CustomerDto;
import com.cg.onlineshopping_application.entity.Customer;
import com.cg.onlineshopping_application.entity.User;
import com.cg.onlineshopping_application.exception.CustomerIdException;
import com.cg.onlineshopping_application.exception.UserNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateCustomerException;
import com.cg.onlineshopping_application.repository.ICustomerRepository;
import com.cg.onlineshopping_application.repository.ILoginRepository;
import com.cg.onlineshopping_application.util.ShoppingConstants;

@Service
public class ICustomerServiceImp implements ICustomerService
{
	@Autowired
	ICustomerRepository customerDao;
	@Autowired
	ILoginRepository userDao;
	
	public Customer addCustomer(CustomerDto customerDto) throws ValidateCustomerException, UserNotFoundException {
		validateCustomer(customerDto);
		Customer customer = new Customer();
		Optional<User> optUser = userDao.findById(customerDto.getUserId());
		if (!optUser.isPresent())
			throw new UserNotFoundException(ShoppingConstants.USER_NOT_FOUND);
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setEmail(customerDto.getEmail());
		customer.setUser(optUser.get());
		return customerDao.save(customer);
	}

	private boolean validateCustomer(CustomerDto customerDto) throws ValidateCustomerException {
	
		if (!customerDto.getFirstName().matches(ShoppingConstants.CUSTOMER_PATTERN))
			throw new ValidateCustomerException(ShoppingConstants.CUSTOMER_CANNOT_BE_EMPTY);
		
		if (!customerDto.getLastName().matches(ShoppingConstants.CUSTOMER_PATTERN))
			throw new ValidateCustomerException(ShoppingConstants.CUSTOMER_CANNOT_BE_EMPTY);
		
		if (!customerDto.getMobileNumber().matches("[1-9][0-9]{9}"))
			throw new ValidateCustomerException(ShoppingConstants.PHONENUMBER_CANNOT_BE_EMPTY);
		
		if (!customerDto.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))
			throw new ValidateCustomerException(ShoppingConstants.EMAIL_CANNOT_BE_EMPTY);
		return true;
	}

	

	public Customer updateCustomer(CustomerDto customerDto) throws CustomerIdException, ValidateCustomerException, UserNotFoundException {
		validateCustomer(customerDto);
		Optional<Customer> optCustomer = customerDao.findById(customerDto.getCustomerId());
		if (!optCustomer.isPresent())
			throw new CustomerIdException(ShoppingConstants.CUSTOMER_NOT_FOUND);
		Optional<User> optUser = userDao.findById(customerDto.getUserId());
		if (!optUser.isPresent())
			throw new UserNotFoundException(ShoppingConstants.USER_NOT_FOUND);
		Customer customer = optCustomer.get();
		User user = optUser.get();
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setEmail(customerDto.getEmail());
		customer.setUser(user);
		return customerDao.save(customer);

	}
	
	

	

	@Override
	public boolean removeCustomer(Integer customerId) throws CustomerIdException {
		
			Optional<Customer> optcustomer = customerDao.findById(customerId);

			if (!optcustomer.isPresent()) {
				throw new CustomerIdException(ShoppingConstants.CUSTOMER_NOT_FOUND);

			}
			customerDao.delete(optcustomer.get());
			return true;
		}



	@Override
	public List<Customer> viewAllCustomers() throws CustomerIdException {
	
			List<Customer> customerlist = customerDao.findAll();
			if (customerlist.isEmpty())
				throw new CustomerIdException(ShoppingConstants.CUSTOMER_NOT_FOUND);
			customerlist.sort((a1, a2) -> a1.getFirstName().compareTo(a2.getFirstName()));
			return customerlist;
		
	}

	@Override
    public Customer getCustomerData(Integer userId) {
        Customer customer = customerDao.getCustomerByUserId(userId);
        return customer;
    }

	@Override
	public Customer viewCustomerById(Integer customerId) throws CustomerIdException {
		Optional<Customer> optcustomer = customerDao.findById(customerId);
		if (!optcustomer.isPresent()) {
			throw new CustomerIdException(ShoppingConstants.CUSTOMER_NOT_FOUND);

		}
		return optcustomer.get();
	}	

}

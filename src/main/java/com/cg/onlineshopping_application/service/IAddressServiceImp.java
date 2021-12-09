package com.cg.onlineshopping_application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping_application.dto.AddressDto;
import com.cg.onlineshopping_application.exception.AddressIdException;
import com.cg.onlineshopping_application.exception.CustomerNotFoundException;
import com.cg.onlineshopping_application.exception.ValidateAddressException;
import com.cg.onlineshopping_application.model.Address;
import com.cg.onlineshopping_application.model.Customer;
import com.cg.onlineshopping_application.repository.IAddressRepository;
import com.cg.onlineshopping_application.repository.ICustomerRepository;
import com.cg.onlineshopping_application.util.FixedValues;

@Service
public class IAddressServiceImp implements IAddressService {

	@Autowired
	IAddressRepository addressDao;
	@Autowired
	private ICustomerRepository customerDao;

	public Address addAddress(AddressDto addressDto) throws ValidateAddressException, CustomerNotFoundException {
		validateAddress(addressDto);
		Address address = new Address();
		Optional<Customer> optCustomer = customerDao.findById(addressDto.getCustomerId());
		if (!optCustomer.isPresent())
			throw new CustomerNotFoundException(FixedValues.CUSTOMER_NOT_FOUND);
		address.setStreetNo(addressDto.getStreetNo());
		address.setBuildingName(addressDto.getBuildingName());
		address.setCity(addressDto.getCity());
		address.setCountry(addressDto.getCountry());
		address.setPincode(addressDto.getPincode());
		address.setState(addressDto.getState());
		address.setCustomer(optCustomer.get());
		return addressDao.save(address);
		
	}

	public Address updateAddress(AddressDto addressDto)
			throws AddressIdException, ValidateAddressException, CustomerNotFoundException {
		validateAddress(addressDto);
		Optional<Address> optAddress = addressDao.findById(addressDto.getAddressId());
		if (!optAddress.isPresent())
			throw new AddressIdException(FixedValues.ADDRESS_NOT_FOUND);
		Optional<Customer> optCustomer = customerDao.findById(addressDto.getCustomerId());
		if (!optCustomer.isPresent())
			throw new CustomerNotFoundException(FixedValues.CUSTOMER_NOT_FOUND);
		Address address = optAddress.get();
		Customer customer = optCustomer.get();
		address.setStreetNo(addressDto.getStreetNo());
		address.setBuildingName(addressDto.getBuildingName());
		address.setCity(addressDto.getCity());
		address.setCountry(addressDto.getCountry());
		address.setPincode(addressDto.getPincode());
		address.setState(addressDto.getState());
		address.setCustomer(customer);
		return addressDao.save(address);

	}

	public boolean validateAddress(AddressDto addressDto) throws ValidateAddressException {
		if (!addressDto.getStreetNo().matches("[A-Za-z0-9]{1,3}")) {
			throw new ValidateAddressException(FixedValues.STREET_CANNOT_BE_EMPTY);
		}
		if (!addressDto.getBuildingName().matches(FixedValues.ADDRESS_PATTERN))
			throw new ValidateAddressException(FixedValues.BUILDING_CANNOT_BE_EMPTY);
		if (!addressDto.getCity().matches(FixedValues.ADDRESS_PATTERN))
			throw new ValidateAddressException(FixedValues.CITY_CANNOT_BE_EMPTY);
		if (!addressDto.getCountry().matches(FixedValues.ADDRESS_PATTERN))
			throw new ValidateAddressException(FixedValues.COUNTRY_CANNOT_BE_EMPTY);
		if (!addressDto.getState().matches(FixedValues.ADDRESS_PATTERN))
			throw new ValidateAddressException(FixedValues.STATE_CANNOT_BE_EMPTY);
		if (!addressDto.getPincode().matches("[1-9][0-9]{5}"))
			throw new ValidateAddressException(FixedValues.PINCODE_CANNOT_BE_EMPTY);
		return true;
	}

	@Override
	public boolean removeAddress(Integer addressId) throws AddressIdException {
		Optional<Address> optaddress = addressDao.findById(addressId);

		if (!optaddress.isPresent()) {
			throw new AddressIdException(FixedValues.ADDRESS_NOT_FOUND);

		}
		addressDao.delete(optaddress.get());
		return true;
	}

	@Override
	public Address viewAddress(Integer addressId) throws AddressIdException {
		Optional<Address> optaddress = addressDao.findById(addressId);
		if (!optaddress.isPresent()) {
			throw new AddressIdException(FixedValues.ADDRESS_NOT_FOUND);

		}
		return optaddress.get();
	}

	@Override
	public List<Address> viewAllAddress() throws AddressIdException {
		List<Address> addresslist = addressDao.findAll();
		if (addresslist.isEmpty())
			throw new AddressIdException(FixedValues.ADDRESS_NOT_FOUND);
		addresslist.sort((a1, a2) -> a1.getState().compareTo(a2.getState()));
		return addresslist;
	}

	@Override
	public Address getAddressData(Integer customerId) {
		Address address = addressDao.getAddressByCustomerId(customerId);
        return address;
	}

}

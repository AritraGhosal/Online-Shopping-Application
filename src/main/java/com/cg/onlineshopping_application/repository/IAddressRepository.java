package com.cg.onlineshopping_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.onlineshopping_application.entity.Address;
import com.cg.onlineshopping_application.entity.Customer;


public interface IAddressRepository extends JpaRepository<Address,Integer>{
	
	@Query("FROM Address a inner Join a.customer c WHERE c.customerId = :customerId")
    public Address getAddressByCustomerId(@Param("customerId") Integer customerId);

}

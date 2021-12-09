package com.cg.onlineshopping_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.onlineshopping_application.model.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Integer>{
	@Query("FROM Customer c inner Join c.user u WHERE u.userId = :userid")
    public Customer getCustomerByUserId(@Param("userid") Integer userid);

}

package com.cg.onlineshopping_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping_application.entity.Order1;


public interface IOrderRepository extends JpaRepository<Order1,Integer>{

	
}

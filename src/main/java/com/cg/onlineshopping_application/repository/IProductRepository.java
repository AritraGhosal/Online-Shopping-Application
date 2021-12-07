package com.cg.onlineshopping_application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping_application.entity.Product;

public interface IProductRepository extends JpaRepository<Product,Integer>{

	Optional<Product> findProductByProductName(String productName);

}

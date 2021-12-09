package com.cg.onlineshopping_application.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping_application.model.Category;

public interface ICategoryRepository extends JpaRepository<Category,Integer>{
}


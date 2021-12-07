package com.cg.onlineshopping_application.service;
import java.util.List;

import com.cg.onlineshopping_application.dto.CategoryDto;
import com.cg.onlineshopping_application.entity.Category;
import com.cg.onlineshopping_application.exception.CategoryIdException;
import com.cg.onlineshopping_application.exception.ValidateCategoryException;


public interface ICategoryService {
	public boolean deleteCategory(Integer catId)throws ValidateCategoryException;
    public Category addCategory(CategoryDto categoryDto)throws ValidateCategoryException;
    public Category updateCategory(CategoryDto categoryDto)throws ValidateCategoryException;
    public List<Category> viewCategory() throws ValidateCategoryException;
}

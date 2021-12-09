package com.cg.onlineshopping_application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping_application.dto.CategoryDto;
import com.cg.onlineshopping_application.exception.CategoryIdException;
import com.cg.onlineshopping_application.exception.ProductIdException;
import com.cg.onlineshopping_application.exception.ValidateCategoryException;
import com.cg.onlineshopping_application.model.Category;
import com.cg.onlineshopping_application.model.Product;
import com.cg.onlineshopping_application.repository.ICategoryRepository;
import com.cg.onlineshopping_application.util.FixedValues;



@Service
public class ICategoryServiceImp implements ICategoryService {

    @Autowired
    ICategoryRepository categoryDao;

    @Override
    public Category addCategory(CategoryDto categoryDto) throws ValidateCategoryException {
        validateCategory(categoryDto);
        Category category = new Category();
        category.setCategoryName(categoryDto.getCategoryName());
        return categoryDao.save(category);
    }


    public Category updateCategory(CategoryDto categoryDto)throws ValidateCategoryException{
        validateCategory(categoryDto);
        Optional<Category> optCategory = categoryDao.findById(categoryDto.getCatId());
        Category category = optCategory.get();
        category.setCategoryName(categoryDto.getCategoryName());
        return categoryDao.save(category);

    }

    public boolean validateCategory(CategoryDto categoryDto) throws ValidateCategoryException {
        if (categoryDto.getCategoryName()==null) 
            throw new ValidateCategoryException(FixedValues.CATEGORY_CANNOT_BE_EMPTY);
    return true;
 }


	@Override
	public boolean deleteCategory(Integer catId) throws ValidateCategoryException {
		Optional<Category> optCategory = categoryDao.findById(catId);
		if(!optCategory.isPresent()) {
			throw new ValidateCategoryException(FixedValues.CATEGORY_NOT_FOUND);
		}
		categoryDao.delete(optCategory.get());
		return true;
	}


	@Override
	public List<Category> viewCategory() throws ValidateCategoryException {
		List<Category> categorylist = categoryDao.findAll();
		if (categorylist.isEmpty())
		   throw new ValidateCategoryException(FixedValues.CATEGORY_NOT_FOUND);
		categorylist.sort((a1, a2) -> a1.getCategoryName().compareTo(a2.getCategoryName()));
		return categorylist;
	}


	
}

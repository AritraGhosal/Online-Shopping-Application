package com.cg.onlineshopping_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.validation.Valid;

import com.cg.onlineshopping_application.dto.CategoryDto;
import com.cg.onlineshopping_application.entity.Category;
import com.cg.onlineshopping_application.entity.Product;
import com.cg.onlineshopping_application.exception.CategoryIdException;
import com.cg.onlineshopping_application.exception.ProductIdException;
import com.cg.onlineshopping_application.exception.ValidateCategoryException;
import com.cg.onlineshopping_application.service.ICategoryServiceImp;
import com.cg.onlineshopping_application.util.ShoppingConstants;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ICategoryServiceImp categoryService;

    @PostMapping("/addcategory")
    public ResponseEntity<String> addCategory(@Valid @RequestBody CategoryDto categoryDto, BindingResult br) throws ValidateCategoryException
    {
        String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new ValidateCategoryException(err);
		}
		try {
			categoryService.addCategory(categoryDto);
			return new ResponseEntity<String>("Category added", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new ValidateCategoryException("Category Name already exists");
		}
    }

    @PutMapping("/updatecategory")
    public ResponseEntity<String> updateCategory(@RequestBody CategoryDto categoryDto) throws ValidateCategoryException
    {
    	System.out.println("Category :"+categoryDto);
		try {
			categoryService.updateCategory(categoryDto);
		} catch (Exception ex) {
			throw new ValidateCategoryException("Category Not Updated.");
		}
		return new ResponseEntity<String>("Category Updated.", HttpStatus.OK);
    }
    
    @DeleteMapping("/deletecategory/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable("id") Integer id) {
    	System.out.println("Category ID:"+id);
		try {
			categoryService.deleteCategory(id);
		} catch (Exception ex) {
			throw new ValidateCategoryException(ex.getMessage());// "Category Not Deleted");
		}
		return new ResponseEntity<String>("Category Deleted.", HttpStatus.OK);
	}
    
    @GetMapping("/viewcategory")
	public ResponseEntity<List<Category>> viewCategory() throws ValidateCategoryException 
	{
		List<Category> categoryList = categoryService.viewCategory();
		return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
	} 
    
}


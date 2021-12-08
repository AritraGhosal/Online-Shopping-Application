package com.cg.onlineshopping_application.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.cg.onlineshopping_application.dto.ProductDto;
import com.cg.onlineshopping_application.dto.SuccessMessageDto;
import com.cg.onlineshopping_application.entity.Product;
import com.cg.onlineshopping_application.exception.CategoryNotFoundException;
import com.cg.onlineshopping_application.exception.ProductIdException;
import com.cg.onlineshopping_application.exception.ValidateProductException;
import com.cg.onlineshopping_application.service.IProductServiceImp;
import com.cg.onlineshopping_application.util.ShoppingConstants;

@Controller
//@RequestMapping("/product")
public class ProductController 
{
    @Autowired
    IProductServiceImp prodservice;
    
 /*   @ResponseBody
    @RequestMapping("/all")
    public String showAll()
    {
    	return "HiHello";
    }*/
    
    @PostMapping("/addproduct")
    public ResponseEntity<String> addProduct(@Valid @RequestBody ProductDto productdto, BindingResult br)
            throws ValidateProductException {
        String err = "";
        if (br.hasErrors()) {
            List<FieldError> errors = br.getFieldErrors();
            for (FieldError error : errors)
                err += error.getDefaultMessage() + "<br/>";
            throw new ValidateProductException(err);
        }
        try {
            prodservice.addProduct(productdto);
            return new ResponseEntity<String>("Product Added", HttpStatus.OK);

        } catch (DataIntegrityViolationException ex) {
            throw new ValidateProductException("Product already exists");
        }
    }

    
    @DeleteMapping("/removeproduct/{productId}")
    public ResponseEntity<String>  removeProduct(@PathVariable("productId") Integer productId) throws ValidateProductException {
    System.out.println("Product ID:"+productId);
    try {
        prodservice.removeProduct(productId);
    } catch (Exception ex) {
        throw new ValidateProductException(ex.getMessage());// "Account Not Deleted");
    }
    return new ResponseEntity<String>("Product Deleted.", HttpStatus.OK);
}
    
    
    @PutMapping("/updateproduct")
    public ResponseEntity<String> updateProduct(@RequestBody ProductDto pro) throws  ValidateProductException {
        System.out.println("Product :"+pro);
        try {
            prodservice.updateProduct(pro);
        } catch (Exception ex) {
            throw new  ValidateProductException("Product Not Updated.");// "Account Not Updated");
        }
        return new ResponseEntity<String>("Product Updated.", HttpStatus.OK);
    }

    
    
    @GetMapping("/getallproducts")
    public ResponseEntity<List<Product>> viewAllProducts() throws ValidateProductException 
    {
        List<Product> productList = prodservice.viewAllProducts();
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }
    
    
    @GetMapping("/getproductbyname/{productName}")
    public ResponseEntity<Product> viewProduct(@PathVariable("productName") String productName) throws ValidateProductException
    {
        Product p=prodservice.viewProduct(productName);   
        return new ResponseEntity<Product>(p, HttpStatus.OK);
    }
    
    @GetMapping("/getproductbycatid/{catId}")
    public ResponseEntity<List<Product>> viewProductsByCategory(@PathVariable("catId") Integer catId) throws ValidateProductException
    {
        	List<Product> productList = prodservice.viewProductsByCategory(catId); 
        
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }
}
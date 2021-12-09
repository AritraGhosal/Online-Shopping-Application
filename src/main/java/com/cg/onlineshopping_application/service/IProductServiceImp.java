package com.cg.onlineshopping_application.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlineshopping_application.dto.ProductDto;
import com.cg.onlineshopping_application.exception.CategoryNotFoundException;
import com.cg.onlineshopping_application.exception.ProductIdException;
import com.cg.onlineshopping_application.exception.ValidateProductException;
import com.cg.onlineshopping_application.model.Category;
import com.cg.onlineshopping_application.model.Product;
import com.cg.onlineshopping_application.repository.ICategoryRepository;
import com.cg.onlineshopping_application.repository.IProductRepository;
import com.cg.onlineshopping_application.util.FixedValues;

@Service
public class IProductServiceImp implements IProductService
{
	@Autowired
	IProductRepository productDao;
	
	@Autowired
	ICategoryRepository categoryDao;

	@Override
    public List<Product> viewAllProducts() throws ValidateProductException {
		List<Product> productlist = productDao.findAll();
		if (productlist.isEmpty())
		   throw new ValidateProductException(FixedValues.PRODUCT_NOT_FOUND);
		productlist.sort((a1, a2) -> a1.getProductName().compareTo(a2.getProductName()));
		return productlist;
	}

	@Override
	public Product addProduct(ProductDto productDto) throws ValidateProductException{
		validateProduct(productDto);
		Optional<Category> optCategory = categoryDao.findById(productDto.getCatId());
		Category category = optCategory.get();
		Product product = new Product();
		product.setProductName(productDto.getProductName());
		product.setPrice(productDto.getPrice());
		product.setColor(productDto.getColor());
		product.setDimension(productDto.getDimension());
		product.setSpecification(productDto.getSpecification());
		product.setManufacturer(productDto.getManufacturer());
		product.setQuantity(productDto.getQuantity());
		product.setCategory(category);
		return productDao.save(product);
	}

	public boolean validateProduct(ProductDto productDto) throws ValidateProductException {
		if (productDto.getProductName()==null) 
			throw new ValidateProductException(FixedValues.PRODUCT_CANNOT_BE_EMPTY);
		if ((productDto.getPrice())<=0)
			throw new ValidateProductException(FixedValues.PRICE_CANNOT_BE_EMPTY);
		if (productDto.getColor()=="")
			throw new ValidateProductException(FixedValues.COLOR_CANNOT_BE_EMPTY);
		if (productDto.getDimension()=="")
			throw new ValidateProductException(FixedValues.DIMENSION_CANNOT_BE_EMPTY);
		if (productDto.getSpecification()=="")
			throw new ValidateProductException(FixedValues.SPECIFICATION_CANNOT_BE_EMPTY);
		if (productDto.getManufacturer()=="")
			throw new ValidateProductException(FixedValues.MANUFACTURER_CANNOT_BE_EMPTY);
		if (productDto.getQuantity()<0)
			throw new ValidateProductException(FixedValues.QUANTITY_CANNOT_BE_EMPTY);
		return true;
	}
	
	@Override
	public Product updateProduct(ProductDto productDto) throws ValidateProductException{
		validateProduct(productDto);
		Optional<Product> optProduct = productDao.findById(productDto.getProductId());	
		Optional<Category> optCategory = categoryDao.findById(productDto.getCatId());
		Product product = optProduct.get();
		Category category = optCategory.get();
		product.setProductName(productDto.getProductName());
		product.setPrice(productDto.getPrice());
		product.setColor(productDto.getColor());
		product.setDimension(productDto.getDimension());
		product.setSpecification(productDto.getSpecification());
		product.setManufacturer(productDto.getManufacturer());
		product.setQuantity(productDto.getQuantity());
		product.setCategory(category);
		return productDao.save(product);
	}

	
	@Override
	public Product viewProduct(String productName) throws ValidateProductException  {
		Optional<Product> optproduct = productDao.findProductByProductName(productName);
		if (!optproduct.isPresent()) {
			throw new ValidateProductException(FixedValues.PRODUCT_NOT_FOUND);

		}
		return optproduct.get();
	}

	@Override
	public List<Product> viewProductsByCategory(Integer catId) throws ValidateProductException{
		List<Product> productlist = productDao.findAll();
		//Optional<Category> optCategory = categoryDao.findById(catId);
		List<Product> productslist=productlist.stream()
		.filter(p ->p.getCategory().getCatId()==catId)
		.collect(Collectors.toList()); 
		return productslist;
	}

	@Override
	public boolean removeProduct(Integer productId) throws ValidateProductException{
		Optional<Product> optProduct = productDao.findById(productId);
		if(!optProduct.isPresent()) {
			throw new ValidateProductException(FixedValues.PRODUCT_NOT_FOUND);
		}
		productDao.delete(optProduct.get());
		return true;
	}

	
	

}
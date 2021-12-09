package com.cg.onlineshopping_application.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="Category",uniqueConstraints={@UniqueConstraint(columnNames={"category_Name"})})
public class Category 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer catId;
	
	@Column(name="category_Name",unique=true)
	private String categoryName;
	
	@JsonIgnore
	@OneToMany(mappedBy="category")
	private List<Product> product;

	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	
}

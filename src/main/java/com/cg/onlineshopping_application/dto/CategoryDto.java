package com.cg.onlineshopping_application.dto;

public class CategoryDto {

    private Integer catId;
    private String categoryName;

    public CategoryDto() {
        super();
    }


    public CategoryDto(Integer catId, String categoryName) {
        super();
        this.catId = catId;
        this.categoryName = categoryName;
    }


    public CategoryDto(String categoryName) {
        super();
        this.categoryName = categoryName;
    }



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

}

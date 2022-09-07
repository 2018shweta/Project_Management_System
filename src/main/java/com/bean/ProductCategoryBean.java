package com.bean;

import java.util.List;

public class ProductCategoryBean {

	
	Integer productId;
	
	List<Integer> categoryId;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public List<Integer> getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(List<Integer> categoryId) {
		this.categoryId = categoryId;
	}

	
	
}

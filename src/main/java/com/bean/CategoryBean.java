package com.bean;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="category")
public class CategoryBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer categoryId;
	
    
	private String categoryName;
	
	private Boolean isActive;
	
	@JsonIgnore
	@OneToMany(mappedBy = "categories")
	Set<SubCategoryBean> subCategories;

	
	@ManyToMany(mappedBy = "categories")
	List<ProductBean> products;
	
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Set<SubCategoryBean> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(Set<SubCategoryBean> subCategories) {
		this.subCategories = subCategories;
	}

	public List<ProductBean> getProducts() {
		return products;
	}

	public void setProducts(List<ProductBean> products) {
		this.products = products;
	}

	
}

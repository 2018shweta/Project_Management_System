package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="subCategory")
public class SubCategoryBean {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer subCategroy;
	
	private String subCategoryName;
	
	private Boolean isActive;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="categoryId",nullable = false)
	CategoryBean categories;

	public Integer getSubCategroy() {
		return subCategroy;
	}

	public void setSubCategroy(Integer subCategroy) {
		this.subCategroy = subCategroy;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	
	
}

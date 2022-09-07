package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.ProductBean;

@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductBean, Integer> {

	
	
}

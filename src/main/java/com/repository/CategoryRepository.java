package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.CategoryBean;


@Repository
public interface CategoryRepository extends CrudRepository<CategoryBean, Integer>{

	List<CategoryBean> findAll();
     
	@Query(value="select * from category where category_name=?1",nativeQuery = true)
	CategoryBean findByCategoryName(String categoryName);

	@Query(value="select * from category where category_id=?1",nativeQuery = true)
	CategoryBean findByCategoryId(Integer categoryId);

	
	
	
}

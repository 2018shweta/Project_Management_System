package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.SubCategoryBean;

@Repository
public interface SubCategoryRepository extends CrudRepository<SubCategoryBean, Integer> {

	List<SubCategoryBean> findAll();
	
	@Query(value="select * from sub_category where sub_category_name =?1 and category_id=?2",nativeQuery = true)
	SubCategoryBean findBysubCategoryNameAndCategories(String subCategoryName, Integer categoryId);

	@Query(value="select * from sub_category where sub_category_id=?1",nativeQuery = true)
	SubCategoryBean findBySubCategoryId(Integer subCategoryId);

	
	
	
	
	
	
}

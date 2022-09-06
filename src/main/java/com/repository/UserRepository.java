package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.bean.UserBean;

@Repository
public interface UserRepository extends CrudRepository<UserBean, Integer>{

	List<UserBean> findAll();
	
	@Query(value="select * from users where email=?1",nativeQuery = true)
	UserBean findByEmail(String email);
	
    @Query(value = "select * from users where user_id=?1",nativeQuery = true)
	UserBean findByUserId(Integer userId);
	
	

	
}

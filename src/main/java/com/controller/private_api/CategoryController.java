package com.controller.private_api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.bean.CategoryBean;
import com.bean.ResponseBean;
import com.repository.CategoryRepository;

@RestController
@RequestMapping("/private_api")
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepo;
	
	@PostMapping("/addCategory")
	public ResponseEntity<?> addCategory(@RequestBody CategoryBean category)
	{
		ResponseBean<CategoryBean> resp =new ResponseBean<>();
		CategoryBean cat=categoryRepo.findByCategoryName(category.getCategoryName());
		if(cat==null)
		{
			
			categoryRepo.save(category);
			resp.setData(category);
			resp.setMsg("category added");
			return ResponseEntity.ok(resp); 
		}
		else {
			resp.setMsg("allready available Category");
			resp.setData(category);
			return ResponseEntity.ok(resp);
		}
	}
	
	@GetMapping("allCategory")
	public ResponseEntity<?> allCategory()
	{
		 List<CategoryBean> categories =categoryRepo.findAll();
		ResponseBean<List<CategoryBean>> resp=new ResponseBean<>();
		resp.setData(categories);
		resp.setMsg("all categories");
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping("/getCategoryById/{categoryId}")
	public ResponseEntity<?> getCategoryById(@RequestBody @PathVariable("categoryId") Integer categoryId)
	{
		
		CategoryBean category=categoryRepo.findByCategoryId(categoryId);
		ResponseBean<CategoryBean> resp=new ResponseBean<>();
		if(category==null)
		{
			resp.setMsg("data is not available");
			return ResponseEntity.ok(resp);
		}
		else {
			
			resp.setData(category);
			resp.setMsg("data is avialable");
			return ResponseEntity.ok(resp);
		}
		
	}
	
  @DeleteMapping("/deleteCategory/{categoryId}")
  public ResponseEntity<?> deleteCategory(@RequestBody @PathVariable("categoryId") Integer categoryId)
  {
	 categoryRepo.deleteById(categoryId);
	 ResponseBean<CategoryBean> resp=new ResponseBean<>();
	
	 resp.setMsg("Category Deleted");
	 
	 return ResponseEntity.ok(resp);
	 
  }
	
}

package com.controller.private_api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ResponseBean;
import com.bean.SubCategoryBean;
import com.repository.SubCategoryRepository;

@RestController
@RequestMapping("/private_api")
@CrossOrigin
public class SubCategoryController {

	@Autowired
	SubCategoryRepository subCategoryRepo;
	
	@PostMapping("/addSubCategory")
	public ResponseEntity<?> addSubCategory(@RequestBody SubCategoryBean subCategoryBean){
		 
		ResponseBean<SubCategoryBean> resp=new ResponseBean<>();
		System.out.println("data"+subCategoryBean.getSubCategoryName()+subCategoryBean.getCategories().getCategoryId());
      SubCategoryBean subCategory =  subCategoryRepo.findBysubCategoryNameAndCategories(subCategoryBean.getSubCategoryName(),subCategoryBean.getCategories().getCategoryId());
      if(subCategory==null)
      {
    	  subCategoryRepo.save(subCategoryBean);
    	  
    	  //System.out.println(subCategory);
    	  resp.setData(subCategoryBean);
    	  resp.setMsg("subCategory Added...");
    	  return ResponseEntity.ok(resp);
    	  
      }else {
    	  resp.setData(subCategory);
    	  resp.setMsg("allready available data");
    	  return ResponseEntity.ok(resp);
      }
	}
	
	
	@GetMapping("/allSubCategory")
	public ResponseEntity<?> addSubCategory()
	{
		List<SubCategoryBean> subCategories=subCategoryRepo.findAll();
		ResponseBean<List<SubCategoryBean>> resp=new ResponseBean<>();
		resp.setData(subCategories);
		resp.setMsg("all subCategories here");
	  return ResponseEntity.ok(resp);	
	}
	
	@DeleteMapping("/deleteSubCategory/{subCategoryId}")
	public ResponseEntity<?> deleteSubCategory(@PathVariable("subCategoryId") Integer subCategoryId)
	{
		
		SubCategoryBean subc=subCategoryRepo.findBySubCategoryId(subCategoryId);
		ResponseBean<SubCategoryBean> resp=new ResponseBean<>();
		subCategoryRepo.deleteById(subCategoryId);
		resp.setData(subc);
		resp.setMsg("subCategory is Deleted");
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping("/getSubCategoryById/{subCategoryId}")
	public ResponseEntity<?> getSubCategoryById(@PathVariable("subCategoryId") Integer subCategoryId)
	{
		SubCategoryBean subc=subCategoryRepo.findBySubCategoryId(subCategoryId);
		ResponseBean<SubCategoryBean> resp=new ResponseBean<>();
		resp.setData(subc);
		resp.setMsg("subCategory available");
		return ResponseEntity.ok(resp);
	}
}

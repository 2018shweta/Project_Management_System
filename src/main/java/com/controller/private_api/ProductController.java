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

import com.bean.ProductBean;
import com.bean.ResponseBean;
import com.repository.ProductRepository;

@RestController
@RequestMapping("/private_api")
@CrossOrigin
public class ProductController  {

	@Autowired
	ProductRepository productRepo;
	
	@PostMapping("/addProduct")
	public ResponseEntity<?> addProduct(@RequestBody ProductBean product)
	{
		productRepo.save(product);
		ResponseBean<ProductBean> resp =new ResponseBean<>();
		resp.setData(product);
		resp.setMsg("Product Added");
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping("/allProduct")
	public ResponseEntity<?> allProduct()
	{
		System.out.println("allproducts method");
		List<ProductBean> products=productRepo.findAll();
		ResponseBean<List<ProductBean>> resp=new ResponseBean<>();
		resp.setData(products);
		resp.setMsg("all products");
		return ResponseEntity.ok(resp);
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable("productId") Integer productId)
	{
		ProductBean p1=productRepo.findByProductId(productId);
		ResponseBean<ProductBean> resp=new ResponseBean<>();
		productRepo.deleteById(productId);
		resp.setData(p1);
		resp.setMsg("deleted product done");
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping("/getProductByProductId/{productId}")
	public ResponseEntity<?> getProductByProductId(@PathVariable("productId") Integer productId)
	{
		ProductBean p1=productRepo.findByProductId(productId);
		ResponseBean<ProductBean> resp=new ResponseBean<>();
		resp.setData(p1);
		resp.setMsg("Get Product By ProductId");
		return ResponseEntity.ok(resp);
	}
	
	
	
	
}

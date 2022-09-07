package com.controller.public_api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.CategoryBean;
import com.bean.ProductBean;
import com.bean.ProductCategoryBean;
import com.bean.ResponseBean;
import com.repository.CategoryRepository;
import com.repository.ProductCategoryRepository;
import com.repository.ProductRepository;

@RestController
@RequestMapping("/public_api")
@CrossOrigin
public class ProductCategoryController {

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	ProductCategoryRepository proCatRepo;
	
	
	
	
	@PostMapping("/addProductCategory")
	public ResponseEntity<?> addProductCtegory(@RequestBody ProductCategoryBean productCategoryBean) {
		System.out.println("productId" + productCategoryBean.getProductId());
		ResponseBean<ProductBean> resproductcategory = new ResponseBean<>();

		ProductBean productBean = productRepo.findByProductId(productCategoryBean.getProductId());
		System.out.println(productBean + "productBewan");
		if (productBean != null) {
			for (int i = 0; i < productCategoryBean.getCategoryId().size(); i++) {
				System.out.println(productCategoryBean.getCategoryId());
				System.out.println(productCategoryBean.getCategoryId().get(i)+"categoryId");
				CategoryBean categoryBean = categoryRepo.findByCategoryId(productCategoryBean.getCategoryId().get(i));
				if (categoryBean != null) {
					productBean.getCategories().add(categoryBean);
					productRepo.save(productBean);
				} else {
					List<Integer> nullCategory = new ArrayList<Integer>();
					nullCategory.add(productCategoryBean.getCategoryId().get(i));
				}
			}
			return ResponseEntity.ok().body(productBean);
		} else {
			resproductcategory.setData(productBean);
			resproductcategory.setMsg("product null");
			return ResponseEntity.ok().body(resproductcategory);
		}

	}
	
	
	
	
	
	
	
	
	
}

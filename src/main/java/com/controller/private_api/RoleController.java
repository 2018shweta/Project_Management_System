package com.controller.private_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.RoleBean;
import com.repository.RoleRepository;

@RestController
@RequestMapping("/private_api")
public class RoleController {

	@Autowired
	RoleRepository roleRepo;
	
	@PostMapping("/addRole")
	public ResponseEntity<?> addRole(@RequestBody RoleBean role)
	{
		try {
			roleRepo.save(role);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(role);
		
	}
	
	
	
}

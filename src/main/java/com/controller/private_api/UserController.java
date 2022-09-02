package com.controller.private_api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.ResponseBean;
import com.bean.UserBean;
import com.repository.RoleRepository;
import com.repository.UserRepository;

@Controller
@RequestMapping("private_api")
@CrossOrigin
public class UserController {
    @Autowired
    UserRepository userRepo;
	
    @Autowired
    RoleRepository roleRepo;
    
	@DeleteMapping("/del/{userId}")
	public ResponseEntity<?> delUser(@RequestBody @PathVariable("userId") Integer userId)
	{
		System.out.println("userConroller");
		//List<UserBean> user=userRepo.findAll();
		UserBean u2=userRepo.findByUserId(userId);
		ResponseBean<UserBean> res=new ResponseBean<>();
		res.setData(u2);
		userRepo.deleteById(userId);
		res.setMsg("deleted user");
		return ResponseEntity.ok(res);
	}
	
	@GetMapping("/allUser")
	public ResponseEntity<?> allUser()
	{
		System.out.println("allUser method");
		 List<UserBean> users= userRepo.findAll();
		 ResponseBean<List<UserBean>> res=new ResponseBean<>();
			/* res.setData(users); */
		 res.setData(users);
		 res.setMsg("allusers ");
		 return ResponseEntity.ok(res);
	}
}

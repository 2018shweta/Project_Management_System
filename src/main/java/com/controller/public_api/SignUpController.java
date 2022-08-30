package com.controller.public_api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.LoginBean;
import com.bean.ResponseBean;
import com.bean.RoleBean;
import com.bean.UserBean;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import com.service.TokenService;

@RestController
@RequestMapping("/public_api")
public class SignUpController {

	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BCryptPasswordEncoder bCp;
	
	@Autowired
	TokenService tokenService;
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody UserBean user)
	{
		UserBean users=userRepo.findByEmail(user.getEmail());
		if(users==null)
		{
			Optional<RoleBean> role= roleRepo.findById(1);
			user.setRole(role.get());
			try {
				user.setPassword(bCp.encode(user.getPassword()));
				userRepo.save(user);	
			}catch(Exception e)
			{
				e.printStackTrace();
				return ResponseEntity.unprocessableEntity().build();
			}
			return ResponseEntity.ok(user);
		}else {
			return ResponseEntity.ok("allready available");
		}
		
		
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginBean login)
	{
	UserBean users=userRepo.findByEmail(login.getEmail());
	System.out.println(users);
	System.out.println(users.getRole().getRoleName());
	System.out.println(login.getEmail());
	System.out.println("login api");
		if(users==null || !bCp.matches(login.getPassword(), users.getPassword()))
		{
			ResponseBean<LoginBean> res = new ResponseBean<>();
			res.setData(login);
			res.setMsg("Invalid Credentials");
			System.out.println("invalis");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(res);
		}
		else {
			ResponseBean<UserBean> res = new ResponseBean<>();
			res.setData(users);
			res.setMsg("Login done...");
			
			String authTokens = tokenService.generateToken(16);
			users.setAuthToken(authTokens);
			userRepo.save(users);
			return ResponseEntity.ok(res);
			
		}
	}

	
	
	
}//main

package com.application.login.Controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.login.DTO.JwtResponse;
import com.application.login.DTO.UserByPassDTO;
import com.application.login.Service.LoginByPassServiceImpl;


import lombok.RequiredArgsConstructor;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class LoginByPassController {
	
	private final LoginByPassServiceImpl loginByPassServiceImpl ;
	 
//	
	
//	http://localhost:8089/users/login/loginByPass
	@PostMapping("/login/loginByPass")
	public ResponseEntity<?> loginByPass(@RequestBody UserByPassDTO userByPassDTO){
		
		System.out.println("Entering int he controller");
		System.out.println(userByPassDTO.getUsername());
		String token =  loginByPassServiceImpl.loginByPass(userByPassDTO.getUsername(),userByPassDTO.getPassword());
		return ResponseEntity.ok(new JwtResponse(token));	
	}


}

package com.application.login.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.login.DTO.JwtResponse;
import com.application.login.DTO.JwtUtil;

import com.application.login.DTO.UserBySignupDTO;

import com.application.login.Service.SignUpServiceImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class SignUpController {
	
	private final SignUpServiceImpl signUpServiceImpl ;

	    private final JwtUtil jwtUtil;
	
//	http://localhost:8089/users/signup
	@PostMapping("/signup")
 public ResponseEntity<?> signUp(@Valid @RequestBody UserBySignupDTO userBySignupDTO){
		
		System.out.println("Entrr into Signup");
		
		String message = signUpServiceImpl.signUp(userBySignupDTO);
		System.out.println(message);
	    Map<String, String> response = new HashMap<>();
	    response.put("message", message);

	    return ResponseEntity.ok(response);
	}
	
	

}

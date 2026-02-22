package com.application.login.Service;

import java.time.Duration;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.login.DTO.JwtUtil;
import com.application.login.DTO.UserByPassDTO;
import com.application.login.DTO.UserBySignupDTO;
import com.application.login.Entity.User;
import com.application.login.Repository.SignUpRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SignUpServiceImpl implements SignUpService{
	
	private final SignUpRepository signUpRepository;
	
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	
	
	@Transactional
	 public String signUp(UserBySignupDTO userBySignupDTO) {

	        if (signUpRepository.findByUsername(userBySignupDTO.getUsername()).isPresent()) {
	            throw new RuntimeException("Username already exists");
	        }

	        if (signUpRepository.findByEmail(userBySignupDTO.getEmail()).isPresent()) {
	            throw new RuntimeException("Email already exists");
	        }
	        
	        
	        
	        User user = new User();
//	        User user = modelmapper.map(userBySignupDTO,User.class) ;
	        user.setUsername(userBySignupDTO.getUsername());
	        user.setEmail(userBySignupDTO.getEmail());
	        user.setMobileNo(userBySignupDTO.getMobileNo());

	     
	        user.setPassword(passwordEncoder.encode(userBySignupDTO.getPassword()));

	        signUpRepository.save(user);

	        return "User registered successfully";
	    }



	 

}

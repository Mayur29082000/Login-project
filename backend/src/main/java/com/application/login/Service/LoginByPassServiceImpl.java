package com.application.login.Service;


import java.time.Duration;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.login.DTO.JwtUtil;
import com.application.login.DTO.UserByPassDTO;

import com.application.login.Entity.User;
import com.application.login.Repository.LoginByPassRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LoginByPassServiceImpl implements LoginByPassService{
	
	private final LoginByPassRepository loginByPassRepository;
	
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	
	public String loginByPass(String username, String password) {
		// TODO Auto-generated method stub
		
		System.out.println(username);
		System.out.println(password);
        User user = loginByPassRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
	          

	    if (!passwordEncoder.matches(password, user.getPassword())) {
	        throw new RuntimeException("Invalid password");
	    }

	    return jwtUtil.generateToken(username);
	}

	 

}
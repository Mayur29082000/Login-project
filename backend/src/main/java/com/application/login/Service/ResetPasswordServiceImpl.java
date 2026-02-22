package com.application.login.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.login.DTO.JwtUtil;
import com.application.login.DTO.ResetPasswordDTO;
import com.application.login.Entity.User;
import com.application.login.Repository.LoginByPassRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResetPasswordServiceImpl implements ResetPasswordService{

	
    private final LoginByPassRepository loginByPassRepository;
    private final PasswordEncoder passwordEncoder;

    public String resetPassword(ResetPasswordDTO dto) {
    	System.out.println(dto.getNewPassword());
        User user = loginByPassRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        
        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        loginByPassRepository.save(user);

        return "Password updated successfully";
    }
}
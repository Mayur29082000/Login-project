package com.application.login.Service;


import org.springframework.stereotype.Service;

import com.application.login.DTO.ResetUsernameDTO;
import com.application.login.Entity.User;
import com.application.login.Repository.LoginByPassRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class ResetUserNameServiceImpl implements ResetUserNameService  {

    private final LoginByPassRepository loginByPassRepository;

    

    public String resetUsername(ResetUsernameDTO dto) {

        // 1️⃣ Check email exists
        User user = loginByPassRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Email not registered"));

        // 2️⃣ Check username already taken
        if (loginByPassRepository.existsByUsername(dto.getNewUsername())) {
            throw new RuntimeException("Username already taken");
        }

      
        user.setUsername(dto.getNewUsername());

        loginByPassRepository.save(user);

        return "Username updated successfully";
    }
}
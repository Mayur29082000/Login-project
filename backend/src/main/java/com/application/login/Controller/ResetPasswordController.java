package com.application.login.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.application.login.DTO.JwtUtil;
import com.application.login.DTO.ResetPasswordDTO;
import com.application.login.Service.ResetPasswordServiceImpl;
import com.application.login.Service.SignUpServiceImpl;

import lombok.RequiredArgsConstructor;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class ResetPasswordController {

    private final ResetPasswordServiceImpl resetPasswordServiceImpl;

//    http://localhost:8089/users/reset-password

    @PutMapping("/reset-password")
    public ResponseEntity<String> resetPassword(
            @RequestBody ResetPasswordDTO dto) {
    	System.out.println("Entering into controller");
        String response = resetPasswordServiceImpl.resetPassword(dto);

        return ResponseEntity.ok(response);
    }
}
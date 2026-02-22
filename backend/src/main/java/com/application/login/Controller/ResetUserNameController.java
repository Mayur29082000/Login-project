package com.application.login.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.application.login.DTO.JwtUtil;
import com.application.login.DTO.ResetUsernameDTO;
import com.application.login.Service.ResetUserNameServiceImpl;
import com.application.login.Service.SignUpServiceImpl;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class ResetUserNameController {

    private final ResetUserNameServiceImpl resetUserNameServiceImpl;

//    http://localhost:8089/users/reset-username
    @PutMapping("/reset-username")
    public ResponseEntity<String> resetUsername(
            @RequestBody ResetUsernameDTO dto) {

        String response = resetUserNameServiceImpl.resetUsername(dto);

        return ResponseEntity.ok(response);
    }
}
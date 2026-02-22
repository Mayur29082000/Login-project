package com.application.login.DTO;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class JwtResponse {

    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }

}
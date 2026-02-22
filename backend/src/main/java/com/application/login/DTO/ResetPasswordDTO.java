package com.application.login.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResetPasswordDTO {

    private String username;
    private String newPassword;
    private String confirmPassword;
    // getters and setters
}
package com.application.login.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResetUsernameDTO {

    private String email;
    private String newUsername;
    private String confirmUsername;

    // getters and setters
}
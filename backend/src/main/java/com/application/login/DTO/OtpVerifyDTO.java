package com.application.login.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OtpVerifyDTO {
    private String mobileNo;
    private String otp;
}
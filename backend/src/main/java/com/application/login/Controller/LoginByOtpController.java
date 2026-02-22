package com.application.login.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.login.DTO.JwtResponse;
import com.application.login.DTO.JwtUtil;
import com.application.login.DTO.MobileRequestDTO;
import com.application.login.DTO.OtpVerifyDTO;
import com.application.login.Service.LoginByOtpServiceImpl;

import lombok.RequiredArgsConstructor;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class LoginByOtpController {
	
	
	 private final LoginByOtpServiceImpl loginByOtpServiceImpl;
	    private final JwtUtil jwtUtil;
	

	
	 // Send OTP
//	http://localhost:8089/users/send-otp
	    @PostMapping("/send-otp")
	    public ResponseEntity<Map<String, String>> sendOtp(
	            @RequestBody MobileRequestDTO request) {
	    	System.out.println(request.getMobileNo());
	        Map<String, String> response = new HashMap<>();

	        try {

	            String otp =
	                loginByOtpServiceImpl.generateOtp(request.getMobileNo());

	            response.put("message", "OTP Sent Successfully");
	            response.put("otp", otp);

	            return ResponseEntity.ok(response);

	        } catch (RuntimeException ex) {

	            response.put("message", ex.getMessage());

	            return ResponseEntity.badRequest().body(response);
	        }
	    }
	    
    // Verify OTP
//    http://localhost:8089/users/verify-otp
    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestBody OtpVerifyDTO request) {

        boolean isValid = loginByOtpServiceImpl
                .validateOtp(request.getMobileNo(), request.getOtp());

        System.out.println(isValid);

        if (isValid) {
            String token = jwtUtil.generateToken(request.getMobileNo());
            return ResponseEntity.ok(new JwtResponse(token));
        }

       
        Map<String, String> error = new HashMap<>();
        error.put("message", "Invalid OTP");

        return ResponseEntity.badRequest().body(error);
    }

}

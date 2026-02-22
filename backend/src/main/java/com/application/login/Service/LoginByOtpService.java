package com.application.login.Service;

public interface LoginByOtpService {
	String generateOtp(String mobileNo);
	boolean validateOtp(String mobileNo, String otp) ;
}

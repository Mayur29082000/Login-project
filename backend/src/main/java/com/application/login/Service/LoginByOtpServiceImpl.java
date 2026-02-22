package com.application.login.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.login.Entity.OtpVerification;
import com.application.login.Repository.LoginByOtpRepository;
import com.application.login.Repository.LoginByPassRepository;

import jakarta.transaction.Transactional;

@Service
public class LoginByOtpServiceImpl implements LoginByOtpService {

    @Autowired
    private LoginByOtpRepository loginByOtpRepository;

    @Autowired
    private LoginByPassRepository loginByPassRepository;
    
    public String generateOtp(String mobileNo) {

       
        if (!loginByPassRepository.existsByMobileNo(mobileNo)) {
            throw new RuntimeException("Mobile number not registered");
        }

        String otp = String.valueOf((int)(Math.random() * 9000) + 1000);

        loginByOtpRepository.deleteByMobileNo(mobileNo);

        OtpVerification otpEntity = new OtpVerification();
        otpEntity.setMobileNo(mobileNo);
        otpEntity.setOtp(otp);
        otpEntity.setExpiryTime(LocalDateTime.now().plusMinutes(5));

        loginByOtpRepository.save(otpEntity);

        return otp;
    }

    @Transactional
    public boolean validateOtp(String mobileNo, String otp) {
    	System.out.println(mobileNo);
    	System.out.println(otp);
        Optional<OtpVerification> otpData =
        		loginByOtpRepository.findByMobileNoAndOtp(mobileNo, otp);

        if (otpData.isPresent()) {

            if (otpData.get().getExpiryTime().isAfter(LocalDateTime.now())) {

            	loginByOtpRepository.deleteByMobileNo(mobileNo);
                return true;
            }
        }

        return false;
    }
}
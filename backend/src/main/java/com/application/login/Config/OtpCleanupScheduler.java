package com.application.login.Config;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.application.login.Entity.OtpVerification;
import com.application.login.Repository.LoginByOtpRepository;

@Component
@EnableScheduling
public class OtpCleanupScheduler {

    @Autowired
    private LoginByOtpRepository otpRepository;

    @Scheduled(fixedRate = 60000) // Every 1 minute
    public void deleteExpiredOtps() {

        List<OtpVerification> all = otpRepository.findAll();

        all.stream()
           .filter(otp -> otp.getExpiryTime().isBefore(LocalDateTime.now()))
           .forEach(otp -> otpRepository.delete(otp));
    }
}
package com.application.login.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.login.Entity.OtpVerification;

public interface LoginByOtpRepository extends JpaRepository<OtpVerification, Long> {

    Optional<OtpVerification> findByMobileNoAndOtp(String mobileNo, String otp);

    void deleteByMobileNo(String mobileNo);

    boolean existsByMobileNo(String mobileNo);
   
}
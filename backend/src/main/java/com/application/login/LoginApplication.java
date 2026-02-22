package com.application.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

@SpringBootApplication
public class LoginApplication {

	public static void main(String[] args) {
		String key = Encoders.BASE64.encode(
                Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256).getEncoded()
        );
        System.out.println(key);
   
		SpringApplication.run(LoginApplication.class, args);
		 
	}

}


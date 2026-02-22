package com.application.login.DTO;



import org.hibernate.validator.constraints.UniqueElements;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserBySignupDTO {
	
	 @NotBlank(message = "Username is required")
	
	    private String username;

	    @NotBlank(message = "Password is required")
	    @Size(min = 6, message = "Password must be at least 6 characters")
	    private String password;

	    @Email(message = "Invalid email format")
	    @NotBlank(message = "Email is required")
	    private String email;

	    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
	    private String mobileNo;

	
}

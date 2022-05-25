package com.codingdojo.lino.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {

	@NotEmpty(message="Please enter a email")
	@Email(message="Enter a valid email")
	private String email;
	
	@NotEmpty(message="Please enter a password")
	@Size(min=6, max=128, message="The password is not correct")
	private String password;

	public LoginUser() {
	
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

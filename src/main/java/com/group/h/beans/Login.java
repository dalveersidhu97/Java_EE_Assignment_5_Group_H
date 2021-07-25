package com.group.h.beans;

import javax.validation.constraints.Size;

public class Login {

	private int userId;
	@Size(min=4, message="username must be greater than 4 characters.")
	private String username;
	@Size(min=3, message="password must be greater or equal to 8 characters.")
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}

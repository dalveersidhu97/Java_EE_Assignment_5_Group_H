package com.group.h.beans;

import javax.validation.constraints.Size;

public class User {

	private int userId;
	@Size(min=3, message="name must be greater than 3")
	private String name;

	@Size(min=5, message="Email must be greater than 5")
	private String email;
	
	private String role;
	
	private String password;
	

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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

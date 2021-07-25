package com.group.h.beans;

import javax.validation.constraints.Size;

public class Register {

	@Size(min=4, message="username must be greater than 4. ")
	private String username;
	@Size(min=8, message="username must be greater than 8. ")
	private String password;
	private int Id;
	@Size(min=3, message="username must be greater than 3. ")
	private String name;
	@Size(min=5, message="username must be greater than 5. ")
	private String email;
	
	private String role;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}

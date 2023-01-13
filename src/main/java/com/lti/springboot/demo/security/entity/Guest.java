package com.lti.springboot.demo.security.entity;

public class Guest {

	private String username;
	private String password;
	private String email;

	public Guest() {
		super();
	}

	public Guest(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Guest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Guest [username=" + username + ", password=" + password + ", email=" + email + "]";
	}

}

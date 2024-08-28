package com.coffeetalk.model;

import java.time.LocalDateTime;

public class User {
	private Long id;
	private String username;
	private String email;
	private String password;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public User(Long id, String username, String email, String password, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
}

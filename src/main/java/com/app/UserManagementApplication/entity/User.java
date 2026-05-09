package com.app.UserManagementApplication.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Name is required")
	private String name;
	@Email(message = "Invalid email")
	private String email;
	@Size(min = 4, max = 20, message = "Password must be atleast 4 characters and atmost 20 characters")
	private String password;
	@NotBlank(message = "Phone number is required")
	@Size(min = 10, max = 10,
	       message = "Phone number must be 10 digits")
	private String phone;
	private String role;
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, @NotBlank(message = "Name is required") String name,
			@Email(message = "Invalid email") String email,
			@Size(min = 4, max = 20, message = "Password must be atleast 4 characters and atmost 20 characters") String password,
			@Size(min = 10, max = 10, message = "Phone number must be 10 digits") String phone, String role,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.role = role;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phone=" + phone
				+ ", role=" + role + ", createdAt=" + createdAt + "]";
	}
	
	
}

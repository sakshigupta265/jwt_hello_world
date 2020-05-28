package com.ravionics.model;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String username;
	@Column
//	@JsonIgnore
	private String password;
	@Column
	private String email;
	@Column
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", Username=" + username + ", email=" + email + ", role=" + role + "]";
	}

}
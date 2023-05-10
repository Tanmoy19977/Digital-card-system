package com.example.poc.springPoc.Entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "user")
public class user {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_password")
	private String userPassword;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, userName, userPassword);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		user other = (user) obj;
		return id == other.id && Objects.equals(userName, other.userName)
				&& Objects.equals(userPassword, other.userPassword);
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	}

	public user(int id, String userName, String userPassword) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public user() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}

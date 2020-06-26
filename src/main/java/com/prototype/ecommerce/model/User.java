/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User definition.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(schema="public",name="user")
public class User implements Serializable {

	/**
	 * User email.
	 */
	@Id
	@Column(name = "email",
			unique = true,
			nullable = false)
	private String email;

	/**
	 * User full name.
	 */
	@Column(name = "full_name")
	private String fullName;

	/**
	 * User password.
	 */
	@Column(name = "password")
	private String password;

	/**
	 * User role for ecommerce system.
	 */
	@Column(name = "role")
	private String role;

	/**
	 * Public non argument constructor. Required by JPA framework.
	 */
	public User() {
		// Do nothing.
	}

	/**
	 * User constructor with all values.
	 *
	 * @param fullName User full name.
	 * @param password User password.
	 * @param email User email.
	 * @param role User role of the user :ROLE_USER or ROLE_ADMIN.
	 */
	public User(String fullName, String password, String email, String role) {

		this.fullName = fullName;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	/**
	 * User constructor with all values except for the password.
	 *
	 * @param fullName User full name.
	 * @param email User email.
	 * @param role User role of the user :ROLE_USER or ROLE_ADMIN.
	 */
	public User(String fullName, String email, String role) {

		this.fullName = fullName;
		this.email = email;
		this.role = role;
	}

	/**
	 * Return user full name.
	 *
	 * @return User full name.
	 */
	public String getFullName() {

		return fullName;
	}

	/**
	 * Sets user full name.
	 *
	 * @param fullName user full name.
	 */
	public void setFullName(String fullName) {

		this.fullName = fullName;
	}

	/**
	 * Return user password MD5 hash.
	 *
	 * @return Password MD5 hash.
	 */
	public String getPassword() {

		return password;
	}

	/**
	 * Sets user password MD5 hash.
	 *
	 * @param password User password MD5 hash.
	 */
	public void setPassword(String password) {

		this.password = password;
	}

	/**
	 * Returns user email.
	 *
	 * @return User email.
	 */
	public String getEmail() {

		return email;
	}

	/**
	 * Sets user email.
	 *
	 * @param email User email.
	 */
	public void setEmail(String email) {

		this.email = email;
	}

	/**
	 * Returns the user role.
	 *
	 * @return User role.
	 */
	public String getRole() {

		return role;
	}

	/**
	 * Sets the user role.
	 *
	 * @param role User role.
	 */
	public void setRole(String role) {

		this.role = role;
	}

	@Override public String toString() {

		return "User{" +
				", fullName='" + fullName + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", role='" + role + '\'' +
				'}';
	}
}

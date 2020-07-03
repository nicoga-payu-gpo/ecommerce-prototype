/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.services;

import com.prototype.ecommerce.model.User;

/**
 * Service that exposes functionalities to manipulate {@linkplain User} entities
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
public interface UserService {

	/**
	 * Creates a new user.
	 *
	 * @param user User to create.
	 * @return Created user.
	 */
	User createUser(User user);

	/**
	 * Get an specific user based on it's email.
	 *
	 * @param email User email.
	 * @return User with the provided email.
	 */
	User getUser(String email);


}

/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.services.servicesImpl;

import com.prototype.ecommerce.model.User;
import com.prototype.ecommerce.repositories.UserRepository;
import com.prototype.ecommerce.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service that exposes functionalities to manipulate {@linkplain User} entities
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@Service
public class UserServiceImpl implements UserService {

	/**
	 * {@linkplain User} entities JPA repository.
	 */
	private final UserRepository userRepository;

	/**
	 * Service constructor.
	 *
	 * @param userRepository Reference to the JPA repository.
	 */
	public UserServiceImpl(UserRepository userRepository) {

		this.userRepository = userRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public User createUser(User user) {

		return userRepository.save(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public User getUser(String email) {
		Optional<User> user=userRepository.findById(email);
		return user.orElse(null);
	}

}

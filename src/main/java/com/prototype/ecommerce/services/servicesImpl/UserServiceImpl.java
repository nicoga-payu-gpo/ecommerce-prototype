/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.services.servicesImpl;

import com.prototype.ecommerce.model.User;
import com.prototype.ecommerce.repositories.UserRepository;
import com.prototype.ecommerce.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	 * Logger class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

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

		User entity = userRepository.save(user);
		LOGGER.info("User: {} successfully saved on the DB.", entity);
		return entity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public User getUser(String email) {

		Optional<User> user = userRepository.findById(email);
		if (user.isPresent()) {
			LOGGER.info("User: {} successfully fetched from the DB.", user.get());
		} else {
			LOGGER.warn("User with email: {} is not present in the the DB.", email);
		}
		return user.orElse(null);
	}

}

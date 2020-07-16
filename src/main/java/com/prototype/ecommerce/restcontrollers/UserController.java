/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.restcontrollers;

import com.prototype.ecommerce.model.User;
import com.prototype.ecommerce.services.UserService;
import com.prototype.ecommerce.utils.StringUtils;
import com.prototype.ecommerce.utils.Token;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the platform users.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@RequestMapping("API/user")
@RestController
public class UserController {

	/**
	 * Service for entity {@linkplain User}.
	 */
	private final UserService userService;

	/**
	 * The overload constructor method of class.
	 *
	 * @param userService The user service.
	 */
	public UserController(UserService userService) {

		this.userService = userService;
	}

	/**
	 * Creates a new User in the platform.
	 *
	 * @param user User to create.
	 * @return Created user.
	 */
	@PostMapping("/signUp")
	public ResponseEntity<User> createUserHandler(@RequestBody User user) {

		user.setRole("ROLE_USER");
		user.setPassword(StringUtils.getMD5Hash(user.getPassword()));
		userService.createUser(user);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	/**
	 * Login a user in the platform.
	 *
	 * @param login User to login.
	 * @return Token for the logged user.
	 */
	@PostMapping("/signIn")
	public ResponseEntity<Token> loginUserHandler(@RequestBody User login) {

		if (login.getEmail() == null || login.getPassword() == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		User user = userService.getUser(login.getEmail());
		if (user == null || !StringUtils.isPasswordValid(login.getPassword(), user.getPassword().trim())) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		user.setPassword(null);
		Token token = new Token(user);
		return new ResponseEntity<>(token, HttpStatus.ACCEPTED);
	}

}

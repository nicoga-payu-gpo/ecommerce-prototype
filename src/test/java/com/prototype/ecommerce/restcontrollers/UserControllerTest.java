/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.restcontrollers;

import com.prototype.ecommerce.model.User;
import com.prototype.ecommerce.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.when;

/**
 * Unit test cases for the {@link UserController} class
 *
 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	/**
	 * Instance of the tested class.
	 */
	@InjectMocks
	UserController userController;

	/**
	 * Mocked service used in {@linkplain UserController}.
	 */
	@Mock
	UserService userService;

	/**
	 * Test the {@linkplain UserController#createUserHandler(User)} method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void createUserHandleTest() {

		User user = new User("Nicolas", "contrasena123", "nicolas@gmail.com", "USER_ROLE");
		when(userService.createUser(any(User.class))).then(returnsFirstArg());
		assertEquals(HttpStatus.ACCEPTED, userController.createUserHandler(user).getStatusCode());

	}

	@Test
	void loginUserHandlerTest() {

		User user = new User("Nicolas", "contrasena123", "nicolas@gmail.com", "USER_ROLE");
		when(userService.getUser("nicolas@gmail.com"))
				.thenReturn(new User("Nicolas", "1ba982bdaa28671155f71d06f34be874", "nicolas@gmail.com", "USER_ROLE"));
		assertEquals(new User("Nicolas", null, "nicolas@gmail.com", "USER_ROLE"),
				userController.loginUserHandler(user).getBody().getUser());
	}
}
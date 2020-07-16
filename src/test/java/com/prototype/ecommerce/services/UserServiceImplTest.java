package com.prototype.ecommerce.services;

import com.prototype.ecommerce.model.User;
import com.prototype.ecommerce.repositories.UserRepository;
import com.prototype.ecommerce.services.servicesImpl.UserServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.when;

/**
 * Unit test cases for the {@link UserServiceImpl} class.
 *
 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

	/**
	 * Mocked repository used in {@linkplain UserServiceImpl}.
	 */
	@Mock
	private UserRepository userRepository;

	/**
	 * Instance of the tested class.
	 */
	@InjectMocks
	private UserServiceImpl userService;

	/**
	 * Test the {@linkplain UserServiceImpl#createUser(User)}  method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void createUser() {

		User user = new User("NICOLAS GARCIA", "djskbhjbhBHJB", "nicolas@gmail.com", "ROLE_USER");
		when(userRepository.save(any(User.class))).then(returnsFirstArg());
		Assert.assertEquals(user, userService.createUser(user));

	}

	/**
	 * Test the {@linkplain UserServiceImpl#getUser(String)}  method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void getUser() {

		User user = new User("NICOLAS GARCIA", "djskbhjbhBHJB", "nicolas@gmail.com", "ROLE_USER");
		when(userRepository.findById("nicolas@gmail.com")).thenReturn(java.util.Optional.of(user));
		Assert.assertEquals(user, userService.getUser("nicolas@gmail.com"));
	}
}
/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.restcontrollers;

import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.model.Product;
import com.prototype.ecommerce.model.User;
import com.prototype.ecommerce.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Unit test cases for the {@link OrderController} class
 *
 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

	/**
	 * Instance of the tested class.
	 */
	@InjectMocks
	OrderController orderController;

	/**
	 * Mocked service used in {@linkplain OrderController}.
	 */
	@Mock
	OrderService orderService;

	/**
	 * Example of orders to make the tests.
	 */
	ArrayList<Order> orders;

	/**
	 * Create orders to make the tests.
	 */
	@BeforeEach
	private void initUseCase() {

		Product p = new Product(11, "PRODUCT1", "Product desc", 100, 15000);
		User u = new User("Nicolas", "HJGUJ", "nicoga97@gmail.com", "ROLE_ADMIN");
		User u2 = new User("Camilo", "HJGUJfdg", "camilo@gmail.com", "ROLE_ADMIN");
		Order order1 = new Order(1, "APROVED", 150000, new Date(),
				"ghjkkj", "klhjk", 10, p, u2);
		Order order2 = new Order(2, "PENDING", 15000, new Date(),
				"ghjkHkj", "klHJJhjk", 1, p,
				u);
		orders = new ArrayList<>();
		orders.add(order1);
		orders.add(order2);
	}

	/**
	 * Test the {@linkplain OrderController#getOrdersHandler()} method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void getOrdersHandlerTest() {

		when(orderService.getOrders()).thenReturn(orders);
		assertEquals(orderController.getOrdersHandler().getBody(), orders);
	}

	/**
	 * Test the {@linkplain OrderController#getOrdersByUserId(String)} ()} method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void getOrdersByUserIdTest() {

		orders.remove(1);
		when(orderService.getOrdersByUser("camilo@gmail.com")).thenReturn(orders);
		assertEquals(orders, orderController.getOrdersByUserId("camilo@gmail.com").getBody());
	}

	/**
	 * Test the {@linkplain OrderController#createOrderHandler(Order)} method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void createOrderHandlerTest() {

		when(orderService.createOrder(any(Order.class))).then(returnsFirstArg());
		assertEquals(orders.get(0), orderController.createOrderHandler(orders.get(0)).getBody());
	}

	/**
	 * Test the {@linkplain OrderController#updateOrderHandler(Order)} method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void updateOrderHandlerTest() {

		when(orderService.updateOrder(any(Order.class))).then(returnsFirstArg());
		assertEquals(orders.get(0), orderController.updateOrderHandler(orders.get(0)).getBody());
	}
}
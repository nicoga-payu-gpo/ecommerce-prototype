/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.services;

import com.prototype.ecommerce.model.Address;
import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.model.Product;
import com.prototype.ecommerce.model.User;
import com.prototype.ecommerce.model.dtos.OrderDto;
import com.prototype.ecommerce.repositories.OrderRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.when;

/**
 * Unit test cases for the {@link OrderServiceImpl} class.
 *
 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

	/**
	 * Mocked repository used in {@linkplain OrderServiceImpl}.
	 */
	@Mock
	private OrderRepository orderRepository;

	/**
	 * Instance of the tested class.
	 */
	@InjectMocks
	private OrderServiceImpl orderService;

	/**
	 * Order to do de tests.
	 */
	private Order o;

	/**
	 * Create an order to make the tests.
	 */
	@BeforeEach
	private void initUseCase() {

		Product p = new Product(1, "PRODUCT1", "Product desc", 100, 15000);
		o = new Order(2, "APROVED", 150000, new Date(),
				"ghjkkj", "klhjk",
				10, p, new User("Nicolas", "HJGUJ", "nicoga97@gmail.com", "ROLE_ADMIN"),
				"34235432", "345345",
				new Address("EWRDWE", "PTO301", "BOGOTA", "BOGOTADC", 4565));
	}

	/**
	 * Test the {@linkplain OrderServiceImpl#createOrder(OrderDto)} method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void createOrderTest() {

		when(orderRepository.save(any(Order.class))).then(returnsFirstArg());
		//TODO
		/*Order order = orderService.createOrder(o);
		Assert.assertEquals(o, order);*/
	}

	/**
	 * Test the {@linkplain OrderServiceImpl#getOrders()} method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void getOrdersTest() {

		List<Order> orders = Collections.singletonList(o);
		when(orderRepository.findAll()).thenReturn(orders);
		Assert.assertEquals(orders, orderService.getOrders());
	}


	/**
	 * Test the {@linkplain OrderServiceImpl#updateOrder(Order)} method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void updateOrderTest() {
		when(orderRepository.save(any(Order.class))).then(returnsFirstArg());
		o.setUnits(50);
		Assert.assertEquals(o,orderService.updateOrder(o));
	}
}
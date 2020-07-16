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
import com.prototype.ecommerce.model.dtos.Payer;
import com.prototype.ecommerce.repositories.OrderRepository;
import com.prototype.ecommerce.services.servicesImpl.OrderServiceImpl;
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
	private Order order;

	/**
	 * Order DTO to do de tests.
	 */
	private OrderDto orderDto;

	/**
	 * Create an order to make the tests.
	 */
	@BeforeEach
	private void initUseCase() {

		User u = new User("Nicolas", "HJGUJ", "nicoga97@gmail.com", "ROLE_ADMIN");
		Address address = new Address("EWRDWE", "PTO301", "BOGOTA", "BOGOTADC", 4565);
		Product p = new Product(1, "PRODUCT1", "Product desc", 100, 15000);
		order = new Order(2, "APPROVED", 150000, new Date(), "hdewhj786dwedfw", "bxwjghdv234gvg3hf3",
				10, p, u, "536373", "45677890", address);
		Payer payer = new Payer("Nicolas", "nicoga97@gmail.com", "6778889", "345677", address, "563836378363", "234",
				"2021/12", "NICOLAS GARCIA", "VISA");
		orderDto = new OrderDto(2, "APPROVED", 150000, new Date(), "hdewhj786dwedfw", "bxwjghdv234gvg3hf3",
				10, "Nicolas", "536373", "45677890", address, payer, p, u);
	}

	/**
	 * Test the {@linkplain OrderServiceImpl#createOrder(OrderDto)} method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void createOrderTest() {

		order = new Order(order.getId(), order.getState(), order.getTotal(), new Date(),
				order.getTransactionId(), order.getPaymentOrderId(), order.getUnits(), order.getProduct(),
				order.getUser(), order.getBuyerDniNumber(), order.getBuyerPhone(), order.getShippingAddress());
		when(orderRepository.save(any(Order.class))).thenReturn(order);
		Assert.assertEquals(order, orderService.createOrder(orderDto));
	}

	/**
	 * Test the {@linkplain OrderServiceImpl#getOrders()} method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void getOrdersTest() {

		List<Order> orders = Collections.singletonList(order);
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
		order.setUnits(50);
		Assert.assertEquals(order, orderService.updateOrder(order));
	}
}
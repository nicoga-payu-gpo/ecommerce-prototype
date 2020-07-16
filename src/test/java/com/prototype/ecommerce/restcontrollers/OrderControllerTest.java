/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.restcontrollers;

import com.prototype.ecommerce.model.Address;
import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.model.Product;
import com.prototype.ecommerce.model.User;
import com.prototype.ecommerce.model.dtos.OrderDto;
import com.prototype.ecommerce.model.dtos.Payer;
import com.prototype.ecommerce.services.OrderService;
import com.prototype.ecommerce.services.PaymentService;
import com.prototype.ecommerce.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

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
	 * Mocked service used in {@linkplain OrderController}.
	 */
	@Mock
	PaymentService paymentService;

	/**
	 * Mocked service used in {@linkplain OrderController}.
	 */
	@Mock
	ProductService productService;

	/**
	 * Example of orders to make the tests.
	 */
	ArrayList<Order> orders;

	/**
	 * Example of orderDto to make tests.
	 */
	OrderDto orderDto;

	/**
	 * Create orders to make the tests.
	 */
	@BeforeEach
	private void initUseCase() {

		Address address = new Address("carrera 2", "casa 1", "Bogota", "BogotaDC", 1233);
		Product p = new Product(11, "PRODUCT1", "Product desc", 100, 15000);
		User u = new User("Nicolas", "HJGUJ", "nicoga97@gmail.com", "ROLE_ADMIN");
		User u2 = new User("Camilo", "HJGUJfdg", "camilo@gmail.com", "ROLE_ADMIN");
		Order order1 = new Order(1, "APPROVED", 150000, new Date(),
				"ghjkkj", "klhjk", 10, p, u2, "34235432", "345345",
				address);
		Order order2 = new Order(2, "PENDING", 15000, new Date(),
				"ghjkHkj", "klHJJhjk", 1, p, u, "34235432", "345345",
				address);
		orders = new ArrayList<>();
		orders.add(order1);
		orders.add(order2);
		Payer payer = new Payer("Nicolas", "nicoga97@gmail.com", "6778889", "345677", address, "563836378363", "234",
				"2021/12", "NICOLAS GARCIA", "VISA");
		orderDto = new OrderDto(0, "APPROVED", 150000, new Date(), "hdewhj786dwedfw", "bxwjghdv234gvg3hf3",
				10, "Nicolas", "536373", "45677890", address, payer, p, u);
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
	 * Test the {@linkplain OrderController#doRefundHandler(String)} method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void doRefundHandlerTest() {

		when(orderService.updateOrder(any(Order.class))).thenAnswer(
				(Answer<Order>) invocation -> {

					Order o = (Order) invocation.getArguments()[0];
					Object mock = invocation.getMock();
					o.setState("REFUNDED");
					return o;
				});
		assertEquals("REFUNDED", orderController.updateOrderHandler(orders.get(0)).getBody().getState());
	}

	/**
	 * Test the {@linkplain OrderController#createAndPayOrderHandler(OrderDto)} } method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void createAndPayOrderHandlerTest() {

		when(productService.updateProduct(any(Product.class))).then(returnsFirstArg());
		when(orderService.createOrder(orderDto)).thenReturn(orders.get(0));
		when(paymentService.doPayment(orderDto)).thenReturn(orders.get(0));
		when(orderService.updateOrder(any(Order.class))).thenReturn(orders.get(0));
		assertEquals(orders.get(0), orderController.createAndPayOrderHandler(orderDto).getBody());
		assertEquals(orders.get(0).getProduct().getAvailableUnits() - 1,
				orderController.createAndPayOrderHandler(orderDto).getBody().getProduct().getAvailableUnits());
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
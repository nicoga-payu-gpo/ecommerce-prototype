/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.restcontrollers;

import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for the platform orders.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@RequestMapping("API/orders")
@RestController
public class OrderController {

	/**
	 * Service for entity {@linkplain Order}.
	 */
	private final OrderService orderService;

	/**
	 * The overload constructor method of class.
	 *
	 * @param orderService The order service.
	 */
	public OrderController(OrderService orderService) {

		this.orderService = orderService;
	}

	/**
	 * Returns all the orders placed in the platform.
	 *
	 * @return All orders placed in the platform.
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<Iterable<Order>> getOrdersHandler() {

		try {
			Iterable<Order> orders = orderService.getOrders();
			for (Order o : orders) {
				o.getUser().setPassword("");
				o.getUser().setRole("");
			}
			return new ResponseEntity<>(orders, HttpStatus.ACCEPTED);
		} catch (Exception ex) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Return all the orders placed in the platform by an specific user.
	 *
	 * @param email User email.
	 * @return All the order placed by the user with the given email.
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{userId}")
	public ResponseEntity<Iterable<Order>> getOrdersByUserId(@PathVariable("userId") String email) {
		try {

			return new ResponseEntity<>(orderService.getOrdersByUser(email), HttpStatus.ACCEPTED);
		} catch (Exception ex) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Creates a new order in the platform.
	 *
	 * @param order Order to create.
	 * @return Created order.
	 */
	@PostMapping
	public ResponseEntity<Order> createOrderHandler(@RequestBody Order order) {
		try {

			return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.ACCEPTED);
		} catch (Exception ex) {

			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Update an existing order.
	 *
	 * @param order Order with the updated values.
	 * @return Updated order.
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping
	public ResponseEntity<Order> updateOrderHandler(@RequestBody Order order) {
		try {

			return new ResponseEntity<>(orderService.updateOrder(order), HttpStatus.ACCEPTED);
		} catch (Exception ex) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


}

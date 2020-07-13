/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.restcontrollers;

import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.model.Product;
import com.prototype.ecommerce.model.dtos.OrderDto;
import com.prototype.ecommerce.services.OrderService;
import com.prototype.ecommerce.services.PaymentService;
import com.prototype.ecommerce.services.ProductService;
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
	 * Service to provide the payment of an Order.
	 */
	private final PaymentService paymentService;

	/**
	 * Service for entity {@linkplain Product}
	 */
	private final ProductService productService;

	/**
	 * The overload constructor method of class.
	 *
	 * @param orderService   The order service.
	 * @param paymentService Payment service.
	 * @param productService
	 */
	public OrderController(OrderService orderService, PaymentService paymentService,
			ProductService productService) {

		this.orderService = orderService;
		this.paymentService = paymentService;
		this.productService = productService;
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
	 * Makes a refund of an order.
	 *
	 * @param orderId Id of the order to refund.
	 * @return Updated order.
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(value = "/refund", consumes = "text/plain")
	public ResponseEntity<Order> doRefundHandler(@RequestBody String orderId) {

		try {
			Order order = orderService.getOrdersById(orderId);
			return new ResponseEntity<>(paymentService.doRefund(order), HttpStatus.ACCEPTED);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Creates a new order and perform the payment in the platform.
	 *
	 * @param order Order to create.
	 * @return Created order.
	 */
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping
	public ResponseEntity<Order> createAndPayOrderHandler(@RequestBody OrderDto order) {

		try {
			Order entity = orderService.createOrder(order);
			order.setId(entity.getId());
			entity = paymentService.doPayment(order);
			if (entity.getState().equals("APPROVED")) {
				Product product = entity.getProduct();
				product.setAvailableUnits(product.getAvailableUnits() - 1);
				productService.updateProduct(product);
			}
			return new ResponseEntity<>(orderService.updateOrder(entity), HttpStatus.ACCEPTED);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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

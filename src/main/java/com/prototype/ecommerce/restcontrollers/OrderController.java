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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	 * Logger class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

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
	 * @param productService Product service.
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

		LOGGER.info("Get orders handler invoked");
		try {
			Iterable<Order> orders = orderService.getOrders();
			for (Order o : orders) {
				o.getUser().setPassword("");
				o.getUser().setRole("");
			}
			return new ResponseEntity<>(orders, HttpStatus.ACCEPTED);
		} catch (Exception ex) {
			LOGGER.error("Error while fetching orders caused by:{}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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

		LOGGER.info("Do refund handler invoked for order id:{}", orderId);
		try {
			Order order = orderService.getOrdersById(orderId);
			order = paymentService.doRefund(order);
			return new ResponseEntity<>(orderService.updateOrder(order), HttpStatus.ACCEPTED);
		} catch (Exception ex) {
			LOGGER.error("Error while processing refund for order id:{} caused by:{}", orderId, ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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

		LOGGER.info("Create and pay order handler invoked for order:{}", order);
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
			LOGGER.error("Error while creating and paying order:{} caused by:{}", order, ex.getMessage());
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

		LOGGER.info("Update order handler invoked for order id:{}", order.getId());
		try {
			return new ResponseEntity<>(orderService.updateOrder(order), HttpStatus.ACCEPTED);
		} catch (Exception ex) {
			LOGGER.error("Error while updating  order id:{} caused by:{}", order.getId(), ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}

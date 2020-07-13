/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.services;

import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.model.dtos.OrderDto;

/**
 * Service that exposes functionalities to manipulate {@linkplain Order} entities
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
public interface OrderService {

	/**
	 * Create a new order.
	 *
	 * @param order Order to create.
	 * @return Created order.
	 */
	Order createOrder(OrderDto order);

	/**
	 * Returns all the orders that has been placed.
	 *
	 * @return All the orders that has been placed.
	 */
	Iterable<Order> getOrders();

	/**
	 * Return  the orders for the given Id.
	 *
	 * @param id order Id to query.
	 * @return The order placed with the given id.
	 */
	Order getOrdersById(String id);

	/**
	 * Update an existing order.
	 *
	 * @param order Order whit updated values.
	 * @return The updated order.
	 */
	Order updateOrder(Order order);
}

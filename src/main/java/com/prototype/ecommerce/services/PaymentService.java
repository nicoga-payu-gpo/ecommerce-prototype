/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.services;

import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.model.dtos.OrderDto;

/**
 * Service that exposes functionalities to manipulate  payment in {@linkplain Order} entities.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
public interface PaymentService {

	/**
	 * Process the payment of an order.
	 *
	 * @param order Order to pay.
	 * @return Order updated.
	 */
	Order doPayment(OrderDto order);

	/**
	 * Process the refund of an order.
	 *
	 * @param order Order to refund.
	 * @return Updated order.
	 */
	Order doRefund(Order order);

}

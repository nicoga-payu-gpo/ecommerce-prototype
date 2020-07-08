/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.services.adapters;

import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.model.dtos.OrderDto;
import org.springframework.stereotype.Service;

/**
 * Adapter that converts a {@linkplain Order} dto object into an entity.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@Service
public class OrderAdapter {

	/**
	 * Coverts a dto order object into an entity, in order to persist only the important data.
	 *
	 * @param order Order dto object.
	 * @return Entity for persistence purpose.
	 */
	public Order adaptOrder(OrderDto order) {

		return new Order(order.getId(), order.getState(), order.getTotal(), order.getDate(),
				order.getTransactionId(), order.getPaymentOrderId(), order.getUnits(), order.getProduct(),
				order.getUser());
	}
}

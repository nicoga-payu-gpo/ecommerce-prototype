/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.services;

import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.model.dtos.OrderDto;

/**
 * Service that exposes functionalities to manipulate  payment in {@linkplain Order} entities
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
public interface PaymentService {

	Order doPayment(OrderDto order);

	Order doRefund(Order order);

}

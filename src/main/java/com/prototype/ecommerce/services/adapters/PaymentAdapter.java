/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.services.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.model.dtos.OrderDto;
import com.prototype.ecommerce.model.paymentpojos.Request;
import com.prototype.ecommerce.model.paymentpojos.response.PaymentResponse;

/**
 * Adapter for payment requests and responses.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
public interface PaymentAdapter {

	/**
	 * Create a payment request.
	 *
	 * @param order Base order to create the request.
	 * @return Created request.
	 */
	Request createPaymentRequest(OrderDto order);

	/**
	 * Adapt payment response.
	 *
	 * @param response Payment response.
	 * @return Adapted response.
	 * @throws JsonProcessingException Json processing exception.
	 */
	PaymentResponse adaptPaymentResponse(String response) throws JsonProcessingException;

	/**
	 * Create a refund request
	 *
	 * @param order Order which is going to be refunded.
	 * @return Refund request.
	 */
	Request createRefundRequest(Order order);
}

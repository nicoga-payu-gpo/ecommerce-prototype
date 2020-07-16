/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.restClient;

import com.prototype.ecommerce.model.paymentpojos.Request;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Feign client that consumes PayU API.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@FeignClient(value = "paymentClient", url = "https://sandbox.api.payulatam.com/payments-api/4.0/service.cgi")
public interface PaymentClient {

	/**
	 * Process a payment.
	 *
	 * @param request request to process.
	 * @return response of the PayU API.
	 */
	@PostMapping(consumes = "application/json")
	String doPayment(@RequestBody Request request);

	/**
	 * Process a refund on a given order.
	 *
	 * @param refundRequest refund to process.
	 * @return Response of the PayU API.
	 */
	@PostMapping(consumes = "application/json")
	String doRefund(@RequestBody Request refundRequest);
}


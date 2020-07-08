/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.restClient;

import com.prototype.ecommerce.model.paymentpojos.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "paymentClient", url = "https://sandbox.api.payulatam.com/payments-api/4.0/service.cgi")
public interface PaymentClient {

	@PostMapping(consumes = "application/json")
	String doPayment(@RequestBody Payment request);
}


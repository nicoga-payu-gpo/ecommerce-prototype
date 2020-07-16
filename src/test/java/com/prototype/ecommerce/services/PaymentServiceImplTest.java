/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prototype.ecommerce.model.Address;
import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.model.Product;
import com.prototype.ecommerce.model.User;
import com.prototype.ecommerce.model.dtos.OrderDto;
import com.prototype.ecommerce.model.dtos.Payer;
import com.prototype.ecommerce.model.paymentpojos.response.PaymentResponsePayu;
import com.prototype.ecommerce.model.paymentpojos.response.TransactionResponse;
import com.prototype.ecommerce.restClient.PaymentClient;
import com.prototype.ecommerce.services.adapters.PaymentAdapter;
import com.prototype.ecommerce.services.servicesImpl.PaymentServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.when;

/**
 * Unit test cases for the {@link PaymentServiceImpl} class.
 *
 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@ExtendWith(MockitoExtension.class)
class PaymentServiceImplTest {
	/**
	 * Instance of the tested class.
	 */
	@InjectMocks
	private PaymentServiceImpl paymentService;

	/**
	 * Adapter used in {@linkplain PaymentServiceImpl}.
	 */
	@Mock
	private PaymentAdapter paymentAdapter;

	/**
	 * Payment client used in {@linkplain PaymentServiceImpl}.
	 */
	@Mock
	private PaymentClient paymentClient;

	/**
	 * Test the {@linkplain PaymentServiceImpl#doPayment(OrderDto)} method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void doPaymentTest() {

		User u = new User("Nicolas", "HJGUJ", "nicoga97@gmail.com", "ROLE_ADMIN");
		Address address = new Address("EWRDWE", "PTO301", "BOGOTA", "BOGOTADC", 4565);
		Product p = new Product(1, "PRODUCT1", "Product desc", 100, 15000);
		Payer payer = new Payer("Nicolas", "nicoga97@gmail.com", "6778889", "345677", address, "563836378363", "234",
				"2021/12", "NICOLAS GARCIA", "VISA");
		OrderDto orderDto = new OrderDto(2, "APPROVED", 150000, new Date(), "hdewhj786dwedfw", "bxwjghdv234gvg3hf3",
				10, "Nicolas", "536373", "45677890", address, payer, p, u);

		try {
			when(paymentAdapter.adaptPaymentResponse(any())).thenReturn(new PaymentResponsePayu("SUCCESS", "APPROVED",
					new TransactionResponse("FWEFEWFER", "FDEWDFWE", "APPROVED")));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		Assert.assertEquals("APPROVED", paymentService.doPayment(orderDto).getState());

	}

	/**
	 * Test the {@linkplain PaymentServiceImpl#doRefund(Order)}  method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void doRefundTest() {

		User u = new User("Nicolas", "HJGUJ", "nicoga97@gmail.com", "ROLE_ADMIN");
		Address address = new Address("EWRDWE", "PTO301", "BOGOTA", "BOGOTADC", 4565);
		Product p = new Product(1, "PRODUCT1", "Product desc", 100, 15000);
		Order order = new Order(2, "APPROVED", 150000, new Date(), "hdewhj786dwedfw", "bxwjghdv234gvg3hf3",
				10, p, u, "536373", "45677890", address);
		try {
			when(paymentAdapter.adaptPaymentResponse(any())).thenReturn(new PaymentResponsePayu("SUCCESS", "APPROVED",
					new TransactionResponse("FWEFEWFER", "FDEWDFWE", "APPROVED")));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		Assert.assertEquals("REFUNDED", paymentService.doRefund(order).getState());
	}
}
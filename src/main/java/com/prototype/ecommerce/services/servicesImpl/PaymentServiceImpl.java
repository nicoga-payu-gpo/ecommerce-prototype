/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.services.servicesImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.model.dtos.OrderDto;
import com.prototype.ecommerce.model.paymentpojos.Request;
import com.prototype.ecommerce.model.paymentpojos.response.PaymentResponsePayu;
import com.prototype.ecommerce.restClient.PaymentClient;
import com.prototype.ecommerce.services.PaymentService;
import com.prototype.ecommerce.services.adapters.PaymentAdapter;
import org.springframework.stereotype.Service;

/**
 * Service implementation that exposes functionalities to manipulate  payment in {@linkplain Order} entities.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	/**
	 * Adapter for payment request creation.
	 */
	private final PaymentAdapter paymentAdapter;

	/**
	 * Client that consumes the payment API.
	 */
	private final PaymentClient paymentClient;

	/**
	 * Service constructor.
	 *
	 * @param paymentAdapter Adapter for payment requests.
	 * @param paymentClient  Payment client.
	 */
	public PaymentServiceImpl(PaymentAdapter paymentAdapter,
			PaymentClient paymentClient) {

		this.paymentAdapter = paymentAdapter;
		this.paymentClient = paymentClient;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public Order doPayment(OrderDto order) {

		Order entity = new Order(order.getId(), order.getState(), order.getTotal(), order.getDate(),
				order.getTransactionId(), order.getPaymentOrderId(), order.getUnits(), order.getProduct(),
				order.getUser(), order.getBuyerDniNumber(), order.getBuyerPhone(), order.getShippingAddress());

		Request requestBody = paymentAdapter.createPaymentRequest(order);
		String stringResponse = paymentClient.doPayment(requestBody);
		PaymentResponsePayu response = null;
		try {
			response = (PaymentResponsePayu) paymentAdapter.adaptPaymentResponse(stringResponse);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		if (response.getStatus().equals("SUCCESS")) {
			entity.setState(response.getTxStatus());
			entity.setTransactionId(response.getTransactionResponse().getTransactionId());
			entity.setPaymentOrderId(response.getTransactionResponse().getOrderId());
		} else {
			entity.setState(response.getStatus());
		}
		System.out.println(response);
		return entity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public Order doRefund(Order order) {

		Request refundRequest = paymentAdapter.createRefundRequest(order);
		String StringRefundResponse = paymentClient.doRefund(refundRequest);
		PaymentResponsePayu response = null;
		try {
			response = (PaymentResponsePayu) paymentAdapter.adaptPaymentResponse(StringRefundResponse);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		if (response.getStatus().equals("SUCCESS")) {
			order.setState("REFUNDED");
		} else {
			order.setState(response.getStatus());
		}
		System.out.println(response);
		return order;
	}

}

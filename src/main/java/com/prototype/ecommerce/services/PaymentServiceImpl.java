package com.prototype.ecommerce.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.model.dtos.OrderDto;
import com.prototype.ecommerce.model.paymentpojos.request.Payment;
import com.prototype.ecommerce.model.paymentpojos.response.PaymentResponsePayu;
import com.prototype.ecommerce.restClient.PaymentClient;
import com.prototype.ecommerce.services.adapters.PaymentAdapter;
import org.springframework.stereotype.Service;

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

	public PaymentServiceImpl(PaymentAdapter paymentAdapter,
			PaymentClient paymentClient) {

		this.paymentAdapter = paymentAdapter;
		this.paymentClient = paymentClient;
	}

	@Override public Order doPayment(OrderDto order) {

		Order entity = new Order(order.getId(), order.getState(), order.getTotal(), order.getDate(),
				order.getTransactionId(), order.getPaymentOrderId(), order.getUnits(), order.getProduct(),
				order.getUser(), order.getBuyerDniNumber(), order.getBuyerPhone(), order.getShippingAddress());

		Payment requestBody = paymentAdapter.createPaymentRequest(order);
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
			entity.setState(response.getTxStatus());
		}
		return entity;
	}
}

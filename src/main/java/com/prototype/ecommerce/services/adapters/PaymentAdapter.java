package com.prototype.ecommerce.services.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.model.dtos.OrderDto;
import com.prototype.ecommerce.model.paymentpojos.Request;
import com.prototype.ecommerce.model.paymentpojos.response.PaymentResponse;

public interface PaymentAdapter {

	Request createPaymentRequest(OrderDto order);

	PaymentResponse adaptPaymentResponse(String response) throws JsonProcessingException;

	Request createRefundRequest(Order order);
}

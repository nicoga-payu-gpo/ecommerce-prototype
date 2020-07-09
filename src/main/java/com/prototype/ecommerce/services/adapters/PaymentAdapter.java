package com.prototype.ecommerce.services.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prototype.ecommerce.model.dtos.OrderDto;
import com.prototype.ecommerce.model.paymentpojos.request.Payment;
import com.prototype.ecommerce.model.paymentpojos.response.PaymentResponse;

public interface PaymentAdapter {

	Payment createPaymentRequest(OrderDto order);

	PaymentResponse adaptPaymentResponse(String response) throws JsonProcessingException;
}

package com.prototype.ecommerce.services.adapters;

import com.prototype.ecommerce.model.dtos.OrderDto;
import com.prototype.ecommerce.model.paymentpojos.Payment;

public interface PaymentAdapter {

	Payment createPaymentRequest(OrderDto order);
}

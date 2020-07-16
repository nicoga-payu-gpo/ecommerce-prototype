/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.services.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.model.dtos.OrderDto;
import com.prototype.ecommerce.model.paymentpojos.paymentrequest.*;
import com.prototype.ecommerce.model.paymentpojos.refundrequest.RefundOrder;
import com.prototype.ecommerce.model.paymentpojos.refundrequest.RefundRequestPayu;
import com.prototype.ecommerce.model.paymentpojos.refundrequest.RefundTransaction;
import com.prototype.ecommerce.model.paymentpojos.response.PaymentResponsePayu;
import com.prototype.ecommerce.utils.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Adapter for Payu payment requests and responses.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@Service
public class PayuAdapter implements PaymentAdapter {

	/**
	 * Merchant api key.
	 */
	private static final String API_KEY = "4Vj8eK4rloUd272L48hsrarnUA";

	/**
	 * Merchant API login.
	 */
	private static final String API_LOGIN = "pRRXKOl8ikMmt9u";

	/**
	 * Account id.
	 */
	private static final String ACCOUNT_ID = "512321";

	/**
	 * Merchant id.
	 */
	private static final String MERCHANT_ID = "508029";

	/**
	 * {@inheritDoc}
	 */
	@Override public PaymentPayU createPaymentRequest(OrderDto data) {

		PaymentAddress billingPaymentAddress = new PaymentAddress(data.getPayer().getBillingAddress().getStreet1(),
				data.getPayer().getBillingAddress().getStreet2(), data.getPayer().getBillingAddress().getCity(),
				data.getPayer().getBillingAddress().getState(), "CO",
				String.valueOf(data.getPayer().getBillingAddress().getPostalCode()),
				String.valueOf(data.getPayer().getPhone()));
		PaymentPayer paymentPayer = new PaymentPayer(data.getPayer().getEmail(), data.getPayer().getName(),
				data.getPayer().getEmail(),
				data.getPayer().getPhone(), data.getPayer().getDniNumber(),
				billingPaymentAddress);
		PaymentAddress shippingPaymentAddress = new PaymentAddress(data.getShippingAddress().getStreet1(),
				data.getShippingAddress().getStreet2(), data.getShippingAddress().getCity(),
				data.getShippingAddress().getState(), "CO", String.valueOf(data.getShippingAddress().getPostalCode()),
				String.valueOf(data.getBuyerPhone()));
		Buyer buyer = new Buyer(data.getUser().getEmail(), data.getBuyerName(), data.getUser().getEmail(),
				String.valueOf(data.getBuyerPhone()), String.valueOf(data.getBuyerDniNumber()), shippingPaymentAddress);
		AdditionalValues additionalValues = new AdditionalValues(new TxValue(data.getTotal(), "COP"),
				new TxValue(0, "COP"), new TxValue(0, "COP"));
		PaymentOrder paymentOrder = new PaymentOrder(ACCOUNT_ID, String.valueOf(data.getId()), "Redonez payment", "es",
				StringUtils
						.getMD5Hash(API_KEY + "~" + MERCHANT_ID + "~" + data.getId() + "~" + data.getTotal() + "~COP"),
				"", additionalValues, buyer);
		CreditCard card = new CreditCard(data.getPayer().getCardNumber(), data.getPayer().getCardSecurityCode(),
				data.getPayer().getCardExpirationDate(), data.getPayer().getCardHolderName());
		Transaction transaction = new Transaction(paymentOrder, paymentPayer, card, "AUTHORIZATION_AND_CAPTURE",
				data.getPayer().getCardFranchise(), "CO", "127.0.0.1", "127.0.0.1", "DFAS",
				"Mozilla/5.0 (Windows NT 5.1; rv:18.0) Gecko/20100101 Firefox/18.0");

		return new PaymentPayU("es", "SUBMIT_TRANSACTION", new Merchant(API_KEY, API_LOGIN), transaction,
				true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public PaymentResponsePayu adaptPaymentResponse(String response) throws JsonProcessingException {

		XmlMapper xmlMapper = new XmlMapper();
		System.out.println(response);
		return xmlMapper.readValue(response, PaymentResponsePayu.class);
	}

	@Override public RefundRequestPayu createRefundRequest(Order order) {

		Merchant refundMerchant = new Merchant(API_KEY, API_LOGIN);
		RefundTransaction transaction = new RefundTransaction(
				new RefundOrder(order.getPaymentOrderId().trim()),
				"REFUND", "CLIENT REQUEST", order.getTransactionId().trim());
		return new RefundRequestPayu("es", "SUBMIT_TRANSACTION", refundMerchant, transaction, true);
	}

}

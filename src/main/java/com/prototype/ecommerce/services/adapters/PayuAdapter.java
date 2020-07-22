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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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
	 * Logger class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PayuAdapter.class);

	/**
	 * Merchant api key.
	 */
	@Value("${payu.api_key}")
	private String apiKey;

	/**
	 * Merchant API login.
	 */
	@Value("${payu.api_login}")
	private String apiLogin;

	/**
	 * Account id.
	 */
	@Value("${payu.account_id}")
	private String accountId;

	/**
	 * Merchant id.
	 */
	@Value("${payu.merchant_id}")
	private String merchantId;

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
		PaymentOrder paymentOrder = new PaymentOrder(accountId, String.valueOf(data.getId()), "Redonez payment", "es",
				StringUtils
						.getMD5Hash(apiKey + "~" + merchantId + "~" + data.getId() + "~" + data.getTotal() + "~COP"),
				"", additionalValues, buyer);
		CreditCard card = new CreditCard(data.getPayer().getCardNumber(), data.getPayer().getCardSecurityCode(),
				data.getPayer().getCardExpirationDate(), data.getPayer().getCardHolderName());
		Transaction transaction = new Transaction(paymentOrder, paymentPayer, card, "AUTHORIZATION_AND_CAPTURE",
				data.getPayer().getCardFranchise(), "CO", "127.0.0.1", "127.0.0.1", "DFAS",
				"Mozilla/5.0 (Windows NT 5.1; rv:18.0) Gecko/20100101 Firefox/18.0");
		PaymentPayU request = new PaymentPayU("es", "SUBMIT_TRANSACTION", new Merchant(apiKey, apiLogin), transaction,
				true);
		LOGGER.info("Payment request successfully created:{}", request);
		return request;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public PaymentResponsePayu adaptPaymentResponse(String response) throws JsonProcessingException {

		XmlMapper xmlMapper = new XmlMapper();
		PaymentResponsePayu adaptedResponse = xmlMapper.readValue(response, PaymentResponsePayu.class);
		LOGGER.info("PayU response successfully adapted:{}", adaptedResponse);
		return adaptedResponse;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public RefundRequestPayu createRefundRequest(Order order) {

		Merchant refundMerchant = new Merchant(apiKey, apiLogin);
		RefundTransaction transaction = new RefundTransaction(
				new RefundOrder(order.getPaymentOrderId().trim()),
				"REFUND", "CLIENT REQUEST", order.getTransactionId().trim());
		RefundRequestPayu refundRequest = new RefundRequestPayu("es", "SUBMIT_TRANSACTION", refundMerchant, transaction,
				true);
		LOGGER.info("PayU refund request successfully created:{}", refundRequest);
		return refundRequest;
	}

	public String getApiLogin() {

		return apiLogin;
	}

	public void setApiLogin(String apiLogin) {

		this.apiLogin = apiLogin;
	}

	public String getAccountId() {

		return accountId;
	}

	public void setAccountId(String accountId) {

		this.accountId = accountId;
	}

	public String getMerchantId() {

		return merchantId;
	}

	public void setMerchantId(String merchantId) {

		this.merchantId = merchantId;
	}

	public String getApiKey() {

		return apiKey;
	}

	public void setApiKey(String apiKey) {

		this.apiKey = apiKey;
	}
}

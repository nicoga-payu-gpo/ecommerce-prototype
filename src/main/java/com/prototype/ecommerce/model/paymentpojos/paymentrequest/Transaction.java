/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.model.paymentpojos.paymentrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

/**
 * POJO transaction  to process the payment with PayU.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"order",
		"payer",
		"creditCard",
		"type",
		"paymentMethod",
		"paymentCountry",
		"deviceSessionId",
		"ipAddress",
		"cookie",
		"userAgent"
})
public class Transaction implements Serializable {

	/**
	 * Serializable class  version number.
	 */
	private static final long serialVersionUID = -546870105272899746L;

	/**
	 * Order in the transaction.
	 */
	@JsonProperty("order")
	private PaymentOrder paymentOrder;

	/**
	 * Transaction payer.
	 */
	@JsonProperty("payer")
	private PaymentPayer paymentPayer;

	/**
	 * Credit card.
	 */
	@JsonProperty("creditCard")
	private CreditCard creditCard;

	/**
	 * Type of transaction.
	 */
	@JsonProperty("type")
	private String type;

	/**
	 * Payment method.
	 */
	@JsonProperty("paymentMethod")
	private String paymentMethod;

	/**
	 * Payment country.
	 */
	@JsonProperty("paymentCountry")
	private String paymentCountry;

	/**
	 * Device session id.
	 */
	@JsonProperty("deviceSessionId")
	private String deviceSessionId;

	/**
	 * Ip address.
	 */
	@JsonProperty("ipAddress")
	private String ipAddress;

	/**
	 * Cookie.
	 */
	@JsonProperty("cookie")
	private String cookie;

	/**
	 * User agent.
	 */
	@JsonProperty("userAgent")
	private String userAgent;

	/**
	 * No args constructor for use in serialization
	 */
	public Transaction() {

	}

	/**
	 * @param deviceSessionId Session id.
	 * @param cookie          Cookie.
	 * @param ipAddress       IpAddress.
	 * @param paymentMethod   Payment Method.
	 * @param userAgent       User Agent in which the transaction is being made.
	 * @param creditCard      Credit card info.
	 * @param type            Type of transaction.
	 * @param paymentPayer    Payer info.
	 * @param paymentCountry  Payment country.
	 * @param paymentOrder    Order info.
	 */
	public Transaction(PaymentOrder paymentOrder, PaymentPayer paymentPayer, CreditCard creditCard, String type,
			String paymentMethod,
			String paymentCountry, String deviceSessionId, String ipAddress, String cookie, String userAgent) {

		super();
		this.paymentOrder = paymentOrder;
		this.paymentPayer = paymentPayer;
		this.creditCard = creditCard;
		this.type = type;
		this.paymentMethod = paymentMethod;
		this.paymentCountry = paymentCountry;
		this.deviceSessionId = deviceSessionId;
		this.ipAddress = ipAddress;
		this.cookie = cookie;
		this.userAgent = userAgent;
	}

	@JsonProperty("order")
	public PaymentOrder getPaymentOrder() {

		return paymentOrder;
	}

	@JsonProperty("order")
	public void setPaymentOrder(PaymentOrder paymentOrder) {

		this.paymentOrder = paymentOrder;
	}

	@JsonProperty("payer")
	public PaymentPayer getPaymentPayer() {

		return paymentPayer;
	}

	@JsonProperty("payer")
	public void setPaymentPayer(PaymentPayer paymentPayer) {

		this.paymentPayer = paymentPayer;
	}

	@JsonProperty("creditCard")
	public CreditCard getCreditCard() {

		return creditCard;
	}

	@JsonProperty("creditCard")
	public void setCreditCard(CreditCard creditCard) {

		this.creditCard = creditCard;
	}

	@JsonProperty("type")
	public String getType() {

		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {

		this.type = type;
	}

	@JsonProperty("paymentMethod")
	public String getPaymentMethod() {

		return paymentMethod;
	}

	@JsonProperty("paymentMethod")
	public void setPaymentMethod(String paymentMethod) {

		this.paymentMethod = paymentMethod;
	}

	@JsonProperty("paymentCountry")
	public String getPaymentCountry() {

		return paymentCountry;
	}

	@JsonProperty("paymentCountry")
	public void setPaymentCountry(String paymentCountry) {

		this.paymentCountry = paymentCountry;
	}

	@JsonProperty("deviceSessionId")
	public String getDeviceSessionId() {

		return deviceSessionId;
	}

	@JsonProperty("deviceSessionId")
	public void setDeviceSessionId(String deviceSessionId) {

		this.deviceSessionId = deviceSessionId;
	}

	@JsonProperty("ipAddress")
	public String getIpAddress() {

		return ipAddress;
	}

	@JsonProperty("ipAddress")
	public void setIpAddress(String ipAddress) {

		this.ipAddress = ipAddress;
	}

	@JsonProperty("cookie")
	public String getCookie() {

		return cookie;
	}

	@JsonProperty("cookie")
	public void setCookie(String cookie) {

		this.cookie = cookie;
	}

	@JsonProperty("userAgent")
	public String getUserAgent() {

		return userAgent;
	}

	@JsonProperty("userAgent")
	public void setUserAgent(String userAgent) {

		this.userAgent = userAgent;
	}

	@Override public String toString() {

		return "Transaction{" +
				"order=" + paymentOrder +
				", payer=" + paymentPayer +
				", creditCard=" + creditCard +
				", type='" + type + '\'' +
				", paymentMethod='" + paymentMethod + '\'' +
				", paymentCountry='" + paymentCountry + '\'' +
				", deviceSessionId='" + deviceSessionId + '\'' +
				", ipAddress='" + ipAddress + '\'' +
				", cookie='" + cookie + '\'' +
				", userAgent='" + userAgent + '\'' +
				'}';
	}
}

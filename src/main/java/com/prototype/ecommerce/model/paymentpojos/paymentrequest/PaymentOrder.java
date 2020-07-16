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
 * POJO of a payment order.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"accountId",
		"referenceCode",
		"description",
		"language",
		"signature",
		"notifyUrl",
		"additionalValues",
		"buyer"
})
public class PaymentOrder implements Serializable {

	/**
	 * Serializable class  version number.
	 */
	private static final long serialVersionUID = -4209033307453710198L;

	/**
	 * Account id.
	 */
	@JsonProperty("accountId")
	private String accountId;

	/**
	 * Reference code for the payment.
	 */
	@JsonProperty("referenceCode")
	private String referenceCode;

	/**
	 * Order description.
	 */
	@JsonProperty("description")
	private String description;

	/**
	 * Language of the order
	 */
	@JsonProperty("language")
	private String language;

	/**
	 * Order signature.
	 */
	@JsonProperty("signature")
	private String signature;

	/**
	 * URL to send notification when the order gets processed.
	 */
	@JsonProperty("notifyUrl")
	private String notifyUrl;

	/**
	 * Additional values for the order.
	 */
	@JsonProperty("additionalValues")
	private AdditionalValues additionalValues;

	/**
	 * Buyer of the order.
	 */
	@JsonProperty("buyer")
	private Buyer buyer;

	private String id;

	/**
	 * No args constructor for use in serialization
	 */
	public PaymentOrder() {

	}

	/**
	 * @param accountId        Account identification number.
	 * @param signature        Signature for the order.
	 * @param description      Order description.
	 * @param notifyUrl        Notification URL.
	 * @param language         Language of order.
	 * @param referenceCode    Reference code.
	 * @param additionalValues Additional values.
	 * @param buyer            Buyer.
	 */
	public PaymentOrder(String accountId, String referenceCode, String description, String language, String signature,
			String notifyUrl, AdditionalValues additionalValues, Buyer buyer) {

		super();
		this.accountId = accountId;
		this.referenceCode = referenceCode;
		this.description = description;
		this.language = language;
		this.signature = signature;
		this.notifyUrl = notifyUrl;
		this.additionalValues = additionalValues;
		this.buyer = buyer;
	}

	@JsonProperty("accountId")
	public String getAccountId() {

		return accountId;
	}

	@JsonProperty("accountId")
	public void setAccountId(String accountId) {

		this.accountId = accountId;
	}

	@JsonProperty("referenceCode")
	public String getReferenceCode() {

		return referenceCode;
	}

	@JsonProperty("referenceCode")
	public void setReferenceCode(String referenceCode) {

		this.referenceCode = referenceCode;
	}

	@JsonProperty("description")
	public String getDescription() {

		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {

		this.description = description;
	}

	@JsonProperty("language")
	public String getLanguage() {

		return language;
	}

	@JsonProperty("language")
	public void setLanguage(String language) {

		this.language = language;
	}

	@JsonProperty("signature")
	public String getSignature() {

		return signature;
	}

	@JsonProperty("signature")
	public void setSignature(String signature) {

		this.signature = signature;
	}

	@JsonProperty("notifyUrl")
	public String getNotifyUrl() {

		return notifyUrl;
	}

	@JsonProperty("notifyUrl")
	public void setNotifyUrl(String notifyUrl) {

		this.notifyUrl = notifyUrl;
	}

	@JsonProperty("additionalValues")
	public AdditionalValues getAdditionalValues() {

		return additionalValues;
	}

	@JsonProperty("additionalValues")
	public void setAdditionalValues(AdditionalValues additionalValues) {

		this.additionalValues = additionalValues;
	}

	@JsonProperty("buyer")
	public Buyer getBuyer() {

		return buyer;
	}

	@JsonProperty("buyer")
	public void setBuyer(Buyer buyer) {

		this.buyer = buyer;
	}

	public String getId() {

		return id;
	}

	public void setId(String id) {

		this.id = id;
	}

	@Override public String toString() {

		return "Order{" +
				"accountId='" + accountId + '\'' +
				", referenceCode='" + referenceCode + '\'' +
				", description='" + description + '\'' +
				", language='" + language + '\'' +
				", signature='" + signature + '\'' +
				", notifyUrl='" + notifyUrl + '\'' +
				", additionalValues=" + additionalValues +
				", buyer=" + buyer +
				", id='" + id + '\'' +
				'}';
	}
}

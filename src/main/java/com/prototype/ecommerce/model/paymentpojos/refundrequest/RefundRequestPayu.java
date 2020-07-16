/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.model.paymentpojos.refundrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.prototype.ecommerce.model.paymentpojos.Request;
import com.prototype.ecommerce.model.paymentpojos.paymentrequest.Merchant;

import java.io.Serializable;

/**
 * POJO of the refund request.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"language",
		"command",
		"merchant",
		"transaction",
		"test"
})
public class RefundRequestPayu extends Request implements Serializable {

	/**
	 * Serializable class  version number.
	 */
	private static final long serialVersionUID = 7858223410938816825L;

	/**
	 * Language of the request.
	 */
	@JsonProperty("language")
	private String language;

	/**
	 * Merchant info.
	 */
	@JsonProperty("merchant")
	private Merchant refundMerchant;

	/**
	 * Transaction details.
	 */
	@JsonProperty("transaction")
	private RefundTransaction refundTransaction;

	/**
	 * Test indicator.
	 */
	@JsonProperty("test")
	private Boolean test;

	/**
	 * No args constructor for use in serialization
	 */
	public RefundRequestPayu() {

	}

	/**
	 * @param test              test indicator.
	 * @param refundMerchant    Merchant details.
	 * @param language          Language of the request.
	 * @param command           Command to perform.
	 * @param refundTransaction Transaction details.
	 */
	public RefundRequestPayu(String language, String command, Merchant refundMerchant,
			RefundTransaction refundTransaction,
			Boolean test) {

		super();
		this.language = language;
		this.command = command;
		this.refundMerchant = refundMerchant;
		this.refundTransaction = refundTransaction;
		this.test = test;
	}

	@JsonProperty("language")
	public String getLanguage() {

		return language;
	}

	@JsonProperty("language")
	public void setLanguage(String language) {

		this.language = language;
	}

	@JsonProperty("merchant")
	public Merchant getRefundMerchant() {

		return refundMerchant;
	}

	@JsonProperty("merchant")
	public void setRefundMerchant(Merchant refundMerchant) {

		this.refundMerchant = refundMerchant;
	}

	@JsonProperty("transaction")
	public RefundTransaction getRefundTransaction() {

		return refundTransaction;
	}

	@JsonProperty("transaction")
	public void setRefundTransaction(RefundTransaction refundTransaction) {

		this.refundTransaction = refundTransaction;
	}

	@JsonProperty("test")
	public Boolean getTest() {

		return test;
	}

	@JsonProperty("test")
	public void setTest(Boolean test) {

		this.test = test;
	}

	@Override public String toString() {

		return "RefundRequestPayu{" +
				"language='" + language + '\'' +
				", command='" + command + '\'' +
				", refundMerchant=" + refundMerchant +
				", transaction=" + refundTransaction +
				", test=" + test +
				'}';
	}
}

/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.model.paymentpojos.refundrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

/**
 * POJO of the transaction to process refund with PayU.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"order",
		"type",
		"reason",
		"parentTransactionId"
})
public class RefundTransaction implements Serializable {

	/**
	 * Serializable class  version number.
	 */
	private static final long serialVersionUID = -5301909450651035462L;

	/**
	 * Transaction order.
	 */
	@JsonProperty("order")
	private RefundOrder refundOrder;

	/**
	 * Type of transaction
	 */
	@JsonProperty("type")
	private String type;

	/**
	 * Transaction reason.
	 */
	@JsonProperty("reason")
	private String reason;

	@JsonProperty("parentTransactionId")
	private String parentTransactionId;

	/**
	 * No args constructor for use in serialization
	 */
	public RefundTransaction() {

	}

	/**
	 * @param reason              Reason for the transaction.
	 * @param type                Type of transaction.
	 * @param refundOrder         Order to refund.
	 * @param parentTransactionId Transaction id .
	 */
	public RefundTransaction(RefundOrder refundOrder, String type, String reason, String parentTransactionId) {

		super();
		this.refundOrder = refundOrder;
		this.type = type;
		this.reason = reason;
		this.parentTransactionId = parentTransactionId;
	}

	@JsonProperty("order")
	public RefundOrder getRefundOrder() {

		return refundOrder;
	}

	@JsonProperty("order")
	public void setRefundOrder(RefundOrder refundOrder) {

		this.refundOrder = refundOrder;
	}

	@JsonProperty("type")
	public String getType() {

		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {

		this.type = type;
	}

	@JsonProperty("reason")
	public String getReason() {

		return reason;
	}

	@JsonProperty("reason")
	public void setReason(String reason) {

		this.reason = reason;
	}

	@JsonProperty("parentTransactionId")
	public String getParentTransactionId() {

		return parentTransactionId;
	}

	@JsonProperty("parentTransactionId")
	public void setParentTransactionId(String parentTransactionId) {

		this.parentTransactionId = parentTransactionId;
	}

	@Override public String toString() {

		return "Transaction{" +
				"refundOrder=" + refundOrder +
				", type='" + type + '\'' +
				", reason='" + reason + '\'' +
				", parentTransactionId='" + parentTransactionId + '\'' +
				'}';
	}
}

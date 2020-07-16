/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.model.paymentpojos.response;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * POJO of transaction response of PayU.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"orderId",
		"transactionId",
		"state"
})
public class TransactionResponse implements Serializable {

	/**
	 * Serializable class  version number.
	 */
	private static final long serialVersionUID = 3215273214278498563L;

	/**
	 * Additional properties of transaction response.
	 */
	@JsonIgnore
	private final Map<String, Object> additionalProperties = new HashMap<>();

	/**
	 * Order id.
	 */
	@JsonProperty("orderId")
	private String orderId;

	/**
	 * Transaction id.
	 */
	@JsonProperty("transactionId")
	private String transactionId;

	/**
	 * Transaction state.
	 */
	@JsonProperty("state")
	private String state;

	/**
	 * No args constructor for use in serialization
	 */
	public TransactionResponse() {

	}

	/**
	 * @param orderId       Order id of the payment provider.
	 * @param state         State of the transaction in the payment provider.
	 * @param transactionId Transaction id in the payment provider.
	 */
	public TransactionResponse(String orderId, String transactionId, String state) {

		super();
		this.orderId = orderId;
		this.transactionId = transactionId;
		this.state = state;
	}

	@JsonProperty("orderId")
	public String getOrderId() {

		return orderId;
	}

	@JsonProperty("orderId")
	public void setOrderId(String orderId) {

		this.orderId = orderId;
	}

	@JsonProperty("transactionId")
	public String getTransactionId() {

		return transactionId;
	}

	@JsonProperty("transactionId")
	public void setTransactionId(String transactionId) {

		this.transactionId = transactionId;
	}

	@JsonProperty("state")
	public String getState() {

		return state;
	}

	@JsonProperty("state")
	public void setState(String state) {

		this.state = state;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {

		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {

		this.additionalProperties.put(name, value);
	}

	@Override public String toString() {

		return "TransactionResponse{" +
				"additionalProperties=" + additionalProperties +
				", orderId='" + orderId + '\'' +
				", transactionId='" + transactionId + '\'' +
				", state='" + state + '\'' +
				'}';
	}
}
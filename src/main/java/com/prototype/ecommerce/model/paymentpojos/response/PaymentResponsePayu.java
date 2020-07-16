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
 * POJO of payment response of PayU.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"code",
		"transactionResponse"
})
public class PaymentResponsePayu extends PaymentResponse implements Serializable {

	/**
	 * Serializable class  version number.
	 */
	private static final long serialVersionUID = 4586426728673723225L;

	/**
	 * Additional properties in the response.
	 */
	@JsonIgnore
	private final Map<String, Object> additionalProperties = new HashMap<>();

	/**
	 * Transaction response.
	 */
	@JsonProperty("transactionResponse")
	private TransactionResponse transactionResponse;

	/**
	 * No args constructor for use in serialization
	 */
	public PaymentResponsePayu() {
		//Do nothing
	}

	/**
	 * Constructor of PayU payment response
	 *
	 * @param status              {@inheritDoc}
	 * @param txStatus            {@inheritDoc}
	 * @param transactionResponse Transaction payU response.
	 */
	public PaymentResponsePayu(String status, String txStatus,
			TransactionResponse transactionResponse) {

		super(status, txStatus);
		this.transactionResponse = transactionResponse;
	}

	@JsonProperty("code")
	@Override public String getStatus() {

		return super.getStatus();
	}

	@JsonProperty("code")
	@Override public void setStatus(String status) {

		super.setStatus(status);
	}

	@Override public String getTxStatus() {

		return transactionResponse.getState();

	}

	@JsonProperty("transactionResponse")
	public TransactionResponse getTransactionResponse() {

		return transactionResponse;
	}

	@JsonProperty("transactionResponse")
	public void setTransactionResponse(TransactionResponse transactionResponse) {

		this.transactionResponse = transactionResponse;
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

		return "PaymentResponsePayu{" +
				"additionalProperties=" + additionalProperties +
				", transactionResponse=" + transactionResponse +
				'}';
	}
}
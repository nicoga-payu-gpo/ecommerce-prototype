package com.prototype.ecommerce.model.paymentpojos.response;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"code",
		"transactionResponse"
})
public class PaymentResponsePayu extends PaymentResponse implements Serializable {

	private static final long serialVersionUID = 4586426728673723225L;

	@JsonIgnore
	private final Map<String, Object> additionalProperties = new HashMap<>();

	@JsonProperty("transactionResponse")
	private TransactionResponse transactionResponse;

	/**
	 * No args constructor for use in serialization
	 */
	public PaymentResponsePayu() {

	}

	/**
	 * @param transactionResponse Response provided by Payu.
	 */
	public PaymentResponsePayu(TransactionResponse transactionResponse) {

		super();

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

	@Override
	public String toString() {

		return new ToStringBuilder(this).append("Status", getStatus())
				.append("transactionResponse", transactionResponse).toString();
	}

}
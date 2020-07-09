package com.prototype.ecommerce.model.paymentpojos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"code",
		"transactionResponse"
})
public class PaymentResponsePayu extends PaymentResponse implements Serializable {

	private static final long serialVersionUID = 4586426728673723225L;

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

	@Override
	public String toString() {

		return new ToStringBuilder(this).append("Status", getStatus())
				.append("transactionResponse", transactionResponse).toString();
	}

}
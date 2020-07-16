/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.model.paymentpojos.response;

/**
 * POJO of a payment response.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
public abstract class PaymentResponse {

	/**
	 * Status
	 */
	private String status;

	/**
	 * Transaction status.
	 */
	private String txStatus;

	/**
	 * Payment response constructor.
	 *
	 * @param status   Status of the response.
	 * @param txStatus Transaction status in the response.
	 */
	public PaymentResponse(String status, String txStatus) {

		this.status = status;
		this.txStatus = txStatus;
	}

	/**
	 * No args constructor for use in serialization
	 */
	public PaymentResponse() {
		//Do Nothing
	}

	public String getTxStatus() {

		return txStatus;
	}

	public void setTxStatus(String txStatus) {

		this.txStatus = txStatus;
	}

	public String getStatus() {

		return status;
	}

	public void setStatus(String status) {

		this.status = status;
	}
}

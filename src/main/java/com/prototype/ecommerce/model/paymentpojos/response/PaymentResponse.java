package com.prototype.ecommerce.model.paymentpojos.response;

public abstract class PaymentResponse {

	private String status;

	private String txStatus;

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

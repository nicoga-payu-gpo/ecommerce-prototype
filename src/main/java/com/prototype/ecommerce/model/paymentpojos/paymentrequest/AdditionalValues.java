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
 * POJO Additional values of a Payu transaction.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"TX_VALUE",
		"TX_TAX",
		"TX_TAX_RETURN_BASE"
})
public class AdditionalValues implements Serializable {

	/**
	 * Serializable class  version number
	 */
	private static final long serialVersionUID = -1044082617433065968L;

	/**
	 * Transaction value.
	 */
	@JsonProperty("TX_VALUE")
	private TxValue txValue;

	/**
	 * Transaction tax value.
	 */
	@JsonProperty("TX_TAX")
	private TxValue txTax;

	/**
	 * Transaction tax return value.
	 */
	@JsonProperty("TX_TAX_RETURN_BASE")
	private TxValue txTaxReturnBase;

	/**
	 * No args constructor for use in serialization
	 */
	public AdditionalValues() {

	}

	/**
	 * @param txValue         Transaction value.
	 * @param txTax           Tax value of the transaction.
	 * @param txTaxReturnBase Transaction tax return base.
	 */
	public AdditionalValues(TxValue txValue, TxValue txTax, TxValue txTaxReturnBase) {

		super();
		this.txValue = txValue;
		this.txTax = txTax;
		this.txTaxReturnBase = txTaxReturnBase;
	}

	@JsonProperty("TX_VALUE")
	public TxValue getTXVALUE() {

		return txValue;
	}

	@JsonProperty("TX_VALUE")
	public void setTXVALUE(TxValue tXVALUE) {

		this.txValue = tXVALUE;
	}

	@JsonProperty("TX_TAX")
	public TxValue getTXTAX() {

		return txTax;
	}

	@JsonProperty("TX_TAX")
	public void setTXTAX(TxValue tXTAX) {

		this.txTax = tXTAX;
	}

	@JsonProperty("TX_TAX_RETURN_BASE")
	public TxValue getTXTAXRETURNBASE() {

		return txTaxReturnBase;
	}

	@JsonProperty("TX_TAX_RETURN_BASE")
	public void setTXTAXRETURNBASE(TxValue tXTAXRETURNBASE) {

		this.txTaxReturnBase = tXTAXRETURNBASE;
	}

	@Override public String toString() {

		return "AdditionalValues{" +
				"txValue=" + txValue +
				", txTax=" + txTax +
				", txTaxReturnBase=" + txTaxReturnBase +
				'}';
	}
}

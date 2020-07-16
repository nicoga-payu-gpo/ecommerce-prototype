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
 * POJO of a merchant for a Payu payment request.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"apiKey",
		"apiLogin"
})
public class Merchant implements Serializable {

	/**
	 * Serializable class version number.
	 */
	private static final long serialVersionUID = 3105455040544444377L;

	/**
	 * API key for merchant.
	 */
	@JsonProperty("apiKey")
	private String apiKey;

	/**
	 * API login for merchant.
	 */
	@JsonProperty("apiLogin")
	private String apiLogin;

	/**
	 * No args constructor for use in serialization
	 */
	public Merchant() {

	}

	/**
	 * @param apiKey   API key for for identification in payment provider.
	 * @param apiLogin APi login for the payment provider.
	 */
	public Merchant(String apiKey, String apiLogin) {

		super();
		this.apiKey = apiKey;
		this.apiLogin = apiLogin;
	}

	@JsonProperty("apiKey")
	public String getApiKey() {

		return apiKey;
	}

	@JsonProperty("apiKey")
	public void setApiKey(String apiKey) {

		this.apiKey = apiKey;
	}

	@JsonProperty("apiLogin")
	public String getApiLogin() {

		return apiLogin;
	}

	@JsonProperty("apiLogin")
	public void setApiLogin(String apiLogin) {

		this.apiLogin = apiLogin;
	}

	@Override public String toString() {

		return "Merchant{" +
				"apiKey='" + apiKey + '\'' +
				", apiLogin='" + apiLogin + '\'' +
				'}';
	}
}

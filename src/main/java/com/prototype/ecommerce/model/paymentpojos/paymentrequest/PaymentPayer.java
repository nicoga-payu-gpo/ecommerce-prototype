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
 * POJO of the payer of the order.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"merchantPayerId",
		"fullName",
		"emailAddress",
		"contactPhone",
		"dniNumber",
		"billingAddress"
})
public class PaymentPayer implements Serializable {

	/**
	 * Serializable class  version number.
	 */
	private static final long serialVersionUID = 6332477753309782174L;

	/**
	 * Payer id.
	 */
	@JsonProperty("merchantPayerId")
	private String merchantPayerId;

	/**
	 * Full name.
	 */
	@JsonProperty("fullName")
	private String fullName;

	/**
	 * Email address.
	 */
	@JsonProperty("emailAddress")
	private String emailAddress;

	/**
	 * Phone number.
	 */
	@JsonProperty("contactPhone")
	private String contactPhone;

	/**
	 * DNI number.
	 */
	@JsonProperty("dniNumber")
	private String dniNumber;

	/**
	 * Billing address.
	 */
	@JsonProperty("billingAddress")
	private PaymentAddress billingAddress;

	/**
	 * No args constructor for use in serialization
	 */
	public PaymentPayer() {

	}

	/**
	 * @param dniNumber       DNI number of the payer.
	 * @param emailAddress    email of the payer.
	 * @param fullName        Full name of the payer.
	 * @param billingAddress  Billing address of the payer.
	 * @param contactPhone    Phone number of the payer.
	 * @param merchantPayerId Identification number in the system for the payer.
	 */
	public PaymentPayer(String merchantPayerId, String fullName, String emailAddress, String contactPhone,
			String dniNumber,
			PaymentAddress billingAddress) {

		super();
		this.merchantPayerId = merchantPayerId;
		this.fullName = fullName;
		this.emailAddress = emailAddress;
		this.contactPhone = contactPhone;
		this.dniNumber = dniNumber;
		this.billingAddress = billingAddress;
	}

	@JsonProperty("merchantPayerId")
	public String getMerchantPayerId() {

		return merchantPayerId;
	}

	@JsonProperty("merchantPayerId")
	public void setMerchantPayerId(String merchantPayerId) {

		this.merchantPayerId = merchantPayerId;
	}

	@JsonProperty("fullName")
	public String getFullName() {

		return fullName;
	}

	@JsonProperty("fullName")
	public void setFullName(String fullName) {

		this.fullName = fullName;
	}

	@JsonProperty("emailAddress")
	public String getEmailAddress() {

		return emailAddress;
	}

	@JsonProperty("emailAddress")
	public void setEmailAddress(String emailAddress) {

		this.emailAddress = emailAddress;
	}

	@JsonProperty("contactPhone")
	public String getContactPhone() {

		return contactPhone;
	}

	@JsonProperty("contactPhone")
	public void setContactPhone(String contactPhone) {

		this.contactPhone = contactPhone;
	}

	@JsonProperty("dniNumber")
	public String getDniNumber() {

		return dniNumber;
	}

	@JsonProperty("dniNumber")
	public void setDniNumber(String dniNumber) {

		this.dniNumber = dniNumber;
	}

	@JsonProperty("billingAddress")
	public PaymentAddress getBillingAddress() {

		return billingAddress;
	}

	@JsonProperty("billingAddress")
	public void setBillingAddress(PaymentAddress billingAddress) {

		this.billingAddress = billingAddress;
	}

	@Override public String toString() {

		return "Payer{" +
				"merchantPayerId='" + merchantPayerId + '\'' +
				", fullName='" + fullName + '\'' +
				", emailAddress='" + emailAddress + '\'' +
				", contactPhone='" + contactPhone + '\'' +
				", dniNumber='" + dniNumber + '\'' +
				", billingAddress=" + billingAddress +
				'}';
	}
}

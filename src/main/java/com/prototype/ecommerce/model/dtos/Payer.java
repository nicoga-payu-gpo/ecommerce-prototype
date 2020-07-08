/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.model.dtos;

import com.prototype.ecommerce.model.Address;

/**
 * Payer dto definition.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
public class Payer {

	/**
	 * Payer name.
	 */
	private String name;

	/**
	 * Payer email.
	 */
	private String email;

	/**
	 * Payer phone number.
	 */
	private String phone;

	/**
	 * Payer dni number.
	 */
	private String dniNumber;

	/**
	 * Credit card billing address.
	 */
	private Address billingAddress;

	/**
	 * Credit card number.
	 */
	private String cardNumber;

	/**
	 * Credit card security number.
	 */
	private String cardSecurityCode;

	/**
	 * Credit card expiration date.
	 */
	private String cardExpirationDate;

	/**
	 * Card holder name.
	 */
	private String cardHolderName;

	/**
	 * Credit card franchise.
	 */
	private String cardFranchise;

	/**
	 * Constructor of the payer class.
	 *
	 * @param name               Name of the buyer.
	 * @param email              Email of the buyer.
	 * @param phone              Phone of the buyer.
	 * @param dniNumber          Dni number of the buyer.
	 * @param billingAddress     Billing address of the credit card.
	 * @param cardNumber         Credit card number.
	 * @param cardSecurityCode   Credit card security code.
	 * @param cardExpirationDate Credit card expiration date.
	 * @param cardHolderName     Credit card holder name.
	 * @param cardFranchise      Credit card franchise.
	 */
	public Payer(String name, String email, String phone, String dniNumber,
			Address billingAddress, String cardNumber, String cardSecurityCode, String cardExpirationDate,
			String cardHolderName, String cardFranchise) {

		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dniNumber = dniNumber;
		this.billingAddress = billingAddress;
		this.cardNumber = cardNumber;
		this.cardSecurityCode = cardSecurityCode;
		this.cardExpirationDate = cardExpirationDate;
		this.cardHolderName = cardHolderName;
		this.cardFranchise = cardFranchise;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getPhone() {

		return phone;
	}

	public void setPhone(String phone) {

		this.phone = phone;
	}

	public String getDniNumber() {

		return dniNumber;
	}

	public void setDniNumber(String dniNumber) {

		this.dniNumber = dniNumber;
	}

	public Address getBillingAddress() {

		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {

		this.billingAddress = billingAddress;
	}

	public String getCardNumber() {

		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {

		this.cardNumber = cardNumber;
	}

	public String getCardSecurityCode() {

		return cardSecurityCode;
	}

	public void setCardSecurityCode(String cardSecurityCode) {

		this.cardSecurityCode = cardSecurityCode;
	}

	public String getCardExpirationDate() {

		return cardExpirationDate;
	}

	public void setCardExpirationDate(String cardExpirationDate) {

		this.cardExpirationDate = cardExpirationDate;
	}

	public String getCardHolderName() {

		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {

		this.cardHolderName = cardHolderName;
	}

	public String getCardFranchise() {

		return cardFranchise;
	}

	public void setCardFranchise(String cardFranchise) {

		this.cardFranchise = cardFranchise;
	}
}

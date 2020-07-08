package com.prototype.ecommerce.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String street1;

	private String street2;

	private String city;

	private String state;

	private int postalCode;

	public Address() {

	}

	public Address(String street1, String street2, String city, String state, int postalCode) {

		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
	}

	public String getStreet1() {

		return street1;
	}

	public void setStreet1(String street1) {

		this.street1 = street1;
	}

	public String getStreet2() {

		return street2;
	}

	public void setStreet2(String street2) {

		this.street2 = street2;
	}

	public String getCity() {

		return city;
	}

	public void setCity(String city) {

		this.city = city;
	}

	public String getState() {

		return state;
	}

	public void setState(String state) {

		this.state = state;
	}

	public int getPostalCode() {

		return postalCode;
	}

	public void setPostalCode(int postalCode) {

		this.postalCode = postalCode;
	}
}

/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Address definition.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@Embeddable
public class Address implements Serializable {

	/**
	 * Street 1.
	 */
	private String street1;

	/**
	 * Street 2.
	 */
	private String street2;

	/**
	 * City
	 */
	private String city;

	/**
	 * State.
	 */
	private String state;

	/**
	 * Postal code.
	 */
	private int postalCode;

	/**
	 * Public non argument constructor. Required by JPA framework.
	 */
	public Address() {
		//Do nothing
	}

	/**
	 * Constructor of an order.
	 *
	 * @param street1    Street 1 of the address.
	 * @param street2    Street 2 of the address.
	 * @param city       City of the address.
	 * @param state      State of the address.
	 * @param postalCode Postal code of the address.
	 */
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

	@Override public String toString() {

		return "Address{" +
				"street1='" + street1 + '\'' +
				", street2='" + street2 + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", postalCode=" + postalCode +
				'}';
	}

	@Override public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Address))
			return false;
		Address address = (Address) o;
		return postalCode == address.postalCode &&
				Objects.equals(street1, address.street1) &&
				Objects.equals(street2, address.street2) &&
				Objects.equals(city, address.city) &&
				Objects.equals(state, address.state);
	}

	@Override public int hashCode() {

		return Objects.hash(street1, street2, city, state, postalCode);
	}
}

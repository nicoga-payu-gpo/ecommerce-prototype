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
 * POJO address for a Payu payment request.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "street1",
        "street2",
        "city",
        "state",
        "country",
        "postalCode",
        "phone"
})
public class PaymentAddress implements Serializable {

    /**
     * Serializable class version number
     */
    private static final long serialVersionUID = -5851712143825069161L;

    /**
     * Street 1 of the address.
     */
    @JsonProperty("street1")
    private String street1;

    /**
     * Street 2 of the address.
     */
    @JsonProperty("street2")
    private String street2;

    /**
     * City of the address.
     */
    @JsonProperty("city")
    private String city;

    /**
     * State of the address.
     */
    @JsonProperty("state")
    private String state;

    /**
     * Country of the address.
     */
    @JsonProperty("country")
    private String country;

    /**
     * Postal code of the address.
     */
    @JsonProperty("postalCode")
    private String postalCode;

    /**
     * Phone number of the address.
     */
    @JsonProperty("phone")
    private String phone;

    /**
     * No args constructor for use in serialization
     */
    public PaymentAddress() {

    }

    /**
     * @param country    Country of the address.
     * @param city       City.
     * @param phone      Phone number.
     * @param postalCode Postal code.
     * @param street1    Street.
     * @param street2    Street additional details,
     * @param state      State.
     */
    public PaymentAddress(String street1, String street2, String city, String state, String country, String postalCode,
            String phone) {

        super();
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.phone = phone;
    }

    @JsonProperty("street1")
    public String getStreet1() {

        return street1;
    }

    @JsonProperty("street1")
    public void setStreet1(String street1) {

        this.street1 = street1;
    }

    @JsonProperty("street2")
    public String getStreet2() {

        return street2;
    }

    @JsonProperty("street2")
    public void setStreet2(String street2) {

        this.street2 = street2;
    }

    @JsonProperty("city")
    public String getCity() {

        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {

        this.city = city;
    }

    @JsonProperty("state")
    public String getState() {

        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {

        this.state = state;
    }

    @JsonProperty("country")
    public String getCountry() {

        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {

        this.country = country;
    }

    @JsonProperty("postalCode")
    public String getPostalCode() {

        return postalCode;
    }

    @JsonProperty("postalCode")
    public void setPostalCode(String postalCode) {

        this.postalCode = postalCode;
    }

    @JsonProperty("phone")
    public String getPhone() {

        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {

        this.phone = phone;
    }

    @Override public String toString() {

        return "Address{" +
                "street1='" + street1 + '\'' +
                ", street2='" + street2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

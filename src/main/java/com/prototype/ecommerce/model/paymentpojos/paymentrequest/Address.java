/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.model.paymentpojos.paymentrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

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
public class Address implements Serializable {

    private static final long serialVersionUID = -5851712143825069161L;

    @JsonProperty("street1")
    private String street1;

    @JsonProperty("street2")
    private String street2;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("country")
    private String country;

    @JsonProperty("postalCode")
    private String postalCode;

    @JsonProperty("phone")
    private String phone;

    /**
     * No args constructor for use in serialization
     */
    public Address() {

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
    public Address(String street1, String street2, String city, String state, String country, String postalCode,
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

    @Override
    public String toString() {

        return new ToStringBuilder(this).append("street1", street1).append("street2", street2).append("city", city)
                .append("state", state).append("country", country).append("postalCode", postalCode)
                .append("phone", phone).toString();
    }

}

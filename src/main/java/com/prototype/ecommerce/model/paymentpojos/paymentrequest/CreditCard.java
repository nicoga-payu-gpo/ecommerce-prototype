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
        "number",
        "securityCode",
        "expirationDate",
        "name"
})
public class CreditCard implements Serializable {

    private static final long serialVersionUID = 6898575016572678948L;

    @JsonProperty("number")
    private String number;

    @JsonProperty("securityCode")
    private String securityCode;

    @JsonProperty("expirationDate")
    private String expirationDate;

    @JsonProperty("name")
    private String name;

    /**
     * No args constructor for use in serialization
     */
    public CreditCard() {

    }

    /**
     * @param number         Number of credit card.
     * @param name           Holder name of the credit card.
     * @param securityCode   Security code of the credit card.
     * @param expirationDate Expiration date of the credit card.
     */
    public CreditCard(String number, String securityCode, String expirationDate, String name) {

        super();
        this.number = number;
        this.securityCode = securityCode;
        this.expirationDate = expirationDate;
        this.name = name;
    }

    @JsonProperty("number")
    public String getNumber() {

        return number;
    }

    @JsonProperty("number")
    public void setNumber(String number) {

        this.number = number;
    }

    @JsonProperty("securityCode")
    public String getSecurityCode() {

        return securityCode;
    }

    @JsonProperty("securityCode")
    public void setSecurityCode(String securityCode) {

        this.securityCode = securityCode;
    }

    @JsonProperty("expirationDate")
    public String getExpirationDate() {

        return expirationDate;
    }

    @JsonProperty("expirationDate")
    public void setExpirationDate(String expirationDate) {

        this.expirationDate = expirationDate;
    }

    @JsonProperty("name")
    public String getName() {

        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {

        this.name = name;
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this).append("number", number).append("securityCode", securityCode)
                .append("expirationDate", expirationDate).append("name", name).toString();
    }

}

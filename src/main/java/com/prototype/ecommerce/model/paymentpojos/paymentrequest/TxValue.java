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
 * POJO value of the transaction  to process the payment with PayU.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "value",
        "currency"
})
public class TxValue implements Serializable {

    /**
     * Serializable class  version number.
     */
    private static final long serialVersionUID = 7596599061997063905L;

    /**
     * Value.
     */
    @JsonProperty("value")
    private float value;

    /**
     * Currency.
     */
    @JsonProperty("currency")
    private String currency;

    /**
     * No args constructor for use in serialization
     */
    public TxValue() {

    }

    /**
     * @param currency Type of currency of the value.
     * @param value    Value of the transaction.
     */
    public TxValue(float value, String currency) {

        super();
        this.value = value;
        this.currency = currency;
    }

    @JsonProperty("value")
    public float getValue() {

        return value;
    }

    @JsonProperty("value")
    public void setValue(float value) {

        this.value = value;
    }

    @JsonProperty("currency")
    public String getCurrency() {

        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {

        this.currency = currency;
    }

    @Override public String toString() {

        return "TxValue{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}

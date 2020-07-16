/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.model.paymentpojos.refundrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

/**
 * POJO value of the order to process refund with PayU.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id"
})
public class RefundOrder implements Serializable {

    /**
     * Serializable class  version number.
     */
    private static final long serialVersionUID = -3094150251364088618L;

    /**
     * Id of the order.
     */
    @JsonProperty("id")
    private String id;

    /**
     * No args constructor for use in serialization
     */
    public RefundOrder() {

    }

    /**
     * @param id Order id.
     */
    public RefundOrder(String id) {

        this.id = id;
    }

    @JsonProperty("id")
    public String getId() {

        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {

        this.id = id;
    }

    @Override public String toString() {

        return "RefundOrder{" +
                "id='" + id + '\'' +
                '}';
    }
}

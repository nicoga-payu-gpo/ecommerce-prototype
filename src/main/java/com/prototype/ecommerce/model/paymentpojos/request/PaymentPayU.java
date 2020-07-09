/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.model.paymentpojos.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * POJO request in order to process the payment with PayU.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "language",
        "command",
        "merchant",
        "transaction",
        "test"
})
public class PaymentPayU implements Serializable, Payment {

    private static final long serialVersionUID = 2642396999832998338L;

    @JsonProperty("language")
    private String language;

    @JsonProperty("command")
    private String command;

    @JsonProperty("merchant")
    private Merchant merchant;

    @JsonProperty("transaction")
    private Transaction transaction;

    @JsonProperty("test")
    private Boolean test;

    /**
     * No args constructor for use in serialization
     */
    public PaymentPayU() {

    }

    /**
     * POJO constructor.
     *
     * @param test        Indicates if the request is a test.
     * @param merchant    Merchant info.
     * @param language    Language of the request.
     * @param command     Type of transaction.
     * @param transaction Transaction information.
     */
    public PaymentPayU(String language, String command, Merchant merchant, Transaction transaction, Boolean test) {

        super();
        this.language = language;
        this.command = command;
        this.merchant = merchant;
        this.transaction = transaction;
        this.test = test;
    }

    @JsonProperty("language")
    public String getLanguage() {

        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {

        this.language = language;
    }

    @JsonProperty("command")
    public String getCommand() {

        return command;
    }

    @JsonProperty("command")
    public void setCommand(String command) {

        this.command = command;
    }

    @JsonProperty("merchant")
    public Merchant getMerchant() {

        return merchant;
    }

    @JsonProperty("merchant")
    public void setMerchant(Merchant merchant) {

        this.merchant = merchant;
    }

    @JsonProperty("transaction")
    public Transaction getTransaction() {

        return transaction;
    }

    @JsonProperty("transaction")
    public void setTransaction(Transaction transaction) {

        this.transaction = transaction;
    }

    @JsonProperty("test")
    public Boolean getTest() {

        return test;
    }

    @JsonProperty("test")
    public void setTest(Boolean test) {

        this.test = test;
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this).append("language", language).append("command", command)
                .append("merchant", merchant).append("transaction", transaction).append("test", test).toString();
    }

}


package com.prototype.ecommerce.model.paymentpojos.refundrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.prototype.ecommerce.model.paymentpojos.Request;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "language",
        "command",
        "merchant",
        "transaction",
        "test"
})
public class RefundRequestPayu implements Serializable, Request {

    private final static long serialVersionUID = 7858223410938816825L;

    @JsonProperty("language")
    private String language;

    @JsonProperty("command")
    private String command;

    @JsonProperty("merchant")
    private RefundMerchant refundMerchant;

    @JsonProperty("transaction")
    private Transaction transaction;

    @JsonProperty("test")
    private Boolean test;

    /**
     * No args constructor for use in serialization
     */
    public RefundRequestPayu() {

    }

    /**
     * @param test
     * @param refundMerchant
     * @param language
     * @param command
     * @param transaction
     */
    public RefundRequestPayu(String language, String command, RefundMerchant refundMerchant, Transaction transaction,
            Boolean test) {

        super();
        this.language = language;
        this.command = command;
        this.refundMerchant = refundMerchant;
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
    public RefundMerchant getRefundMerchant() {

        return refundMerchant;
    }

    @JsonProperty("merchant")
    public void setRefundMerchant(RefundMerchant refundMerchant) {

        this.refundMerchant = refundMerchant;
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

        return new ToStringBuilder(this).append("language", language).append("command", command).append("merchant",
                refundMerchant).append("transaction", transaction).append("test", test).toString();
    }

}

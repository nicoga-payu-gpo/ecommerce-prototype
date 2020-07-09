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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "merchantBuyerId",
        "fullName",
        "emailAddress",
        "contactPhone",
        "dniNumber",
        "shippingAddress"
})
public class Buyer implements Serializable {

    private static final long serialVersionUID = 1369164545871014928L;

    @JsonProperty("merchantBuyerId")
    private String merchantBuyerId;

    @JsonProperty("fullName")
    private String fullName;

    @JsonProperty("emailAddress")
    private String emailAddress;

    @JsonProperty("contactPhone")
    private String contactPhone;

    @JsonProperty("dniNumber")
    private String dniNumber;

    @JsonProperty("shippingAddress")
    private Address shippingAddress;

    /**
     * No args constructor for use in serialization
     */
    public Buyer() {

    }

    /**
     * @param dniNumber       DNI number of the buyer.
     * @param emailAddress    email of the buyer.
     * @param merchantBuyerId Identification number in the system for the buyer.
     * @param fullName        Full name of the buyer.
     * @param shippingAddress Shipping address for the product.
     * @param contactPhone    Phone number of the buyer.
     */
    public Buyer(String merchantBuyerId, String fullName, String emailAddress, String contactPhone, String dniNumber,
            Address shippingAddress) {

        super();
        this.merchantBuyerId = merchantBuyerId;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.contactPhone = contactPhone;
        this.dniNumber = dniNumber;
        this.shippingAddress = shippingAddress;
    }

    @JsonProperty("merchantBuyerId")
    public String getMerchantBuyerId() {

        return merchantBuyerId;
    }

    @JsonProperty("merchantBuyerId")
    public void setMerchantBuyerId(String merchantBuyerId) {

        this.merchantBuyerId = merchantBuyerId;
    }

    @JsonProperty("fullName")
    public String getFullName() {

        return fullName;
    }

    @JsonProperty("fullName")
    public void setFullName(String fullName) {

        this.fullName = fullName;
    }

    @JsonProperty("emailAddress")
    public String getEmailAddress() {

        return emailAddress;
    }

    @JsonProperty("emailAddress")
    public void setEmailAddress(String emailAddress) {

        this.emailAddress = emailAddress;
    }

    @JsonProperty("contactPhone")
    public String getContactPhone() {

        return contactPhone;
    }

    @JsonProperty("contactPhone")
    public void setContactPhone(String contactPhone) {

        this.contactPhone = contactPhone;
    }

    @JsonProperty("dniNumber")
    public String getDniNumber() {

        return dniNumber;
    }

    @JsonProperty("dniNumber")
    public void setDniNumber(String dniNumber) {

        this.dniNumber = dniNumber;
    }

    @JsonProperty("shippingAddress")
    public Address getShippingAddress() {

        return shippingAddress;
    }

    @JsonProperty("shippingAddress")
    public void setShippingAddress(Address shippingAddress) {

        this.shippingAddress = shippingAddress;
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this).append("merchantBuyerId", merchantBuyerId).append("fullName", fullName)
                .append("emailAddress", emailAddress).append("contactPhone", contactPhone)
                .append("dniNumber", dniNumber).append("shippingAddress", shippingAddress).toString();
    }

}

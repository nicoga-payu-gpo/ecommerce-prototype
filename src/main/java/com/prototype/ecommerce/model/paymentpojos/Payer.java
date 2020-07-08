
package com.prototype.ecommerce.model.paymentpojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "merchantPayerId",
        "fullName",
        "emailAddress",
        "contactPhone",
        "dniNumber",
        "billingAddress"
})
public class Payer implements Serializable {

    private static final long serialVersionUID = 6332477753309782174L;

    @JsonProperty("merchantPayerId")
    private String merchantPayerId;

    @JsonProperty("fullName")
    private String fullName;

    @JsonProperty("emailAddress")
    private String emailAddress;

    @JsonProperty("contactPhone")
    private String contactPhone;

    @JsonProperty("dniNumber")
    private String dniNumber;

    @JsonProperty("billingAddress")
    private Address billingAddress;

    /**
     * No args constructor for use in serialization
     */
    public Payer() {

    }

    /**
     * @param dniNumber
     * @param emailAddress
     * @param fullName
     * @param billingAddress
     * @param contactPhone
     * @param merchantPayerId
     */
    public Payer(String merchantPayerId, String fullName, String emailAddress, String contactPhone, String dniNumber,
            Address billingAddress) {

        super();
        this.merchantPayerId = merchantPayerId;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.contactPhone = contactPhone;
        this.dniNumber = dniNumber;
        this.billingAddress = billingAddress;
    }

    @JsonProperty("merchantPayerId")
    public String getMerchantPayerId() {

        return merchantPayerId;
    }

    @JsonProperty("merchantPayerId")
    public void setMerchantPayerId(String merchantPayerId) {

        this.merchantPayerId = merchantPayerId;
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

    @JsonProperty("billingAddress")
    public Address getBillingAddress() {

        return billingAddress;
    }

    @JsonProperty("billingAddress")
    public void setBillingAddress(Address billingAddress) {

        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this).append("merchantPayerId", merchantPayerId).append("fullName", fullName)
                .append("emailAddress", emailAddress).append("contactPhone", contactPhone)
                .append("dniNumber", dniNumber).append("billingAddress", billingAddress).toString();
    }

}

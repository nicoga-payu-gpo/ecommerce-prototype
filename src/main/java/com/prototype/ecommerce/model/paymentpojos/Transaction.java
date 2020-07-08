
package com.prototype.ecommerce.model.paymentpojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "order",
        "payer",
        "creditCard",
        "type",
        "paymentMethod",
        "paymentCountry",
        "deviceSessionId",
        "ipAddress",
        "cookie",
        "userAgent"
})
public class Transaction implements Serializable {

    private static final long serialVersionUID = -546870105272899746L;

    @JsonProperty("order")
    private Order order;

    @JsonProperty("payer")
    private Payer payer;

    @JsonProperty("creditCard")
    private CreditCard creditCard;

    @JsonProperty("type")
    private String type;

    @JsonProperty("paymentMethod")
    private String paymentMethod;

    @JsonProperty("paymentCountry")
    private String paymentCountry;

    @JsonProperty("deviceSessionId")
    private String deviceSessionId;

    @JsonProperty("ipAddress")
    private String ipAddress;

    @JsonProperty("cookie")
    private String cookie;

    @JsonProperty("userAgent")
    private String userAgent;

    /**
     * No args constructor for use in serialization
     */
    public Transaction() {

    }

    /**
     * @param deviceSessionId
     * @param cookie
     * @param ipAddress
     * @param paymentMethod
     * @param userAgent
     * @param creditCard
     * @param type
     * @param payer
     * @param paymentCountry
     * @param order
     */
    public Transaction(Order order, Payer payer, CreditCard creditCard, String type, String paymentMethod,
            String paymentCountry, String deviceSessionId, String ipAddress, String cookie, String userAgent) {

        super();
        this.order = order;
        this.payer = payer;
        this.creditCard = creditCard;
        this.type = type;
        this.paymentMethod = paymentMethod;
        this.paymentCountry = paymentCountry;
        this.deviceSessionId = deviceSessionId;
        this.ipAddress = ipAddress;
        this.cookie = cookie;
        this.userAgent = userAgent;
    }

    @JsonProperty("order")
    public Order getOrder() {

        return order;
    }

    @JsonProperty("order")
    public void setOrder(Order order) {

        this.order = order;
    }

    @JsonProperty("payer")
    public Payer getPayer() {

        return payer;
    }

    @JsonProperty("payer")
    public void setPayer(Payer payer) {

        this.payer = payer;
    }

    @JsonProperty("creditCard")
    public CreditCard getCreditCard() {

        return creditCard;
    }

    @JsonProperty("creditCard")
    public void setCreditCard(CreditCard creditCard) {

        this.creditCard = creditCard;
    }

    @JsonProperty("type")
    public String getType() {

        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {

        this.type = type;
    }

    @JsonProperty("paymentMethod")
    public String getPaymentMethod() {

        return paymentMethod;
    }

    @JsonProperty("paymentMethod")
    public void setPaymentMethod(String paymentMethod) {

        this.paymentMethod = paymentMethod;
    }

    @JsonProperty("paymentCountry")
    public String getPaymentCountry() {

        return paymentCountry;
    }

    @JsonProperty("paymentCountry")
    public void setPaymentCountry(String paymentCountry) {

        this.paymentCountry = paymentCountry;
    }

    @JsonProperty("deviceSessionId")
    public String getDeviceSessionId() {

        return deviceSessionId;
    }

    @JsonProperty("deviceSessionId")
    public void setDeviceSessionId(String deviceSessionId) {

        this.deviceSessionId = deviceSessionId;
    }

    @JsonProperty("ipAddress")
    public String getIpAddress() {

        return ipAddress;
    }

    @JsonProperty("ipAddress")
    public void setIpAddress(String ipAddress) {

        this.ipAddress = ipAddress;
    }

    @JsonProperty("cookie")
    public String getCookie() {

        return cookie;
    }

    @JsonProperty("cookie")
    public void setCookie(String cookie) {

        this.cookie = cookie;
    }

    @JsonProperty("userAgent")
    public String getUserAgent() {

        return userAgent;
    }

    @JsonProperty("userAgent")
    public void setUserAgent(String userAgent) {

        this.userAgent = userAgent;
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this).append("order", order).append("payer", payer).append("creditCard", creditCard)
                .append("type", type).append("paymentMethod", paymentMethod).append("paymentCountry", paymentCountry)
                .append("deviceSessionId", deviceSessionId).append("ipAddress", ipAddress).append("cookie", cookie)
                .append("userAgent", userAgent).toString();
    }

}

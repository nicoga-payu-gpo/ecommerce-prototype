
package com.prototype.ecommerce.model.paymentpojos.refundrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "order",
        "type",
        "reason",
        "parentTransactionId"
})
public class Transaction implements Serializable {

    private final static long serialVersionUID = -5301909450651035462L;

    @JsonProperty("order")
    private RefundOrder refundOrder;

    @JsonProperty("type")
    private String type;

    @JsonProperty("reason")
    private String reason;

    @JsonProperty("parentTransactionId")
    private String parentTransactionId;

    /**
     * No args constructor for use in serialization
     */
    public Transaction() {

    }

    /**
     * @param reason
     * @param type
     * @param refundOrder
     * @param parentTransactionId
     */
    public Transaction(RefundOrder refundOrder, String type, String reason, String parentTransactionId) {

        super();
        this.refundOrder = refundOrder;
        this.type = type;
        this.reason = reason;
        this.parentTransactionId = parentTransactionId;
    }

    @JsonProperty("order")
    public RefundOrder getRefundOrder() {

        return refundOrder;
    }

    @JsonProperty("order")
    public void setRefundOrder(RefundOrder refundOrder) {

        this.refundOrder = refundOrder;
    }

    @JsonProperty("type")
    public String getType() {

        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {

        this.type = type;
    }

    @JsonProperty("reason")
    public String getReason() {

        return reason;
    }

    @JsonProperty("reason")
    public void setReason(String reason) {

        this.reason = reason;
    }

    @JsonProperty("parentTransactionId")
    public String getParentTransactionId() {

        return parentTransactionId;
    }

    @JsonProperty("parentTransactionId")
    public void setParentTransactionId(String parentTransactionId) {

        this.parentTransactionId = parentTransactionId;
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this).append("order", refundOrder).append("type", type).append("reason", reason)
                .append("parentTransactionId", parentTransactionId).toString();
    }

}


package com.prototype.ecommerce.model.paymentpojos.refundrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id"
})
public class RefundOrder implements Serializable {

    private final static long serialVersionUID = -3094150251364088618L;

    @JsonProperty("id")
    private String id;

    /**
     * No args constructor for use in serialization
     */
    public RefundOrder() {

    }

    /**
     * @param id
     */
    public RefundOrder(String id) {

        super();
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

    @Override
    public String toString() {

        return new ToStringBuilder(this).append("id", id).toString();
    }

}

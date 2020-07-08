
package com.prototype.ecommerce.model.paymentpojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "TX_VALUE",
        "TX_TAX",
        "TX_TAX_RETURN_BASE"
})
public class AdditionalValues implements Serializable {

    private static final long serialVersionUID = -1044082617433065968L;

    @JsonProperty("TX_VALUE")
    private TxValue txValue;

    @JsonProperty("TX_TAX")
    private TxValue txTax;

    @JsonProperty("TX_TAX_RETURN_BASE")
    private TxValue txTaxReturnBase;

    /**
     * No args constructor for use in serialization
     */
    public AdditionalValues() {

    }

    /**
     * @param tXVALUE
     * @param tXTAX
     * @param tXTAXRETURNBASE
     */
    public AdditionalValues(TxValue tXVALUE, TxValue tXTAX, TxValue tXTAXRETURNBASE) {

        super();
        this.txValue = tXVALUE;
        this.txTax = tXTAX;
        this.txTaxReturnBase = tXTAXRETURNBASE;
    }

    @JsonProperty("TX_VALUE")
    public TxValue getTXVALUE() {

        return txValue;
    }

    @JsonProperty("TX_VALUE")
    public void setTXVALUE(TxValue tXVALUE) {

        this.txValue = tXVALUE;
    }

    @JsonProperty("TX_TAX")
    public TxValue getTXTAX() {

        return txTax;
    }

    @JsonProperty("TX_TAX")
    public void setTXTAX(TxValue tXTAX) {

        this.txTax = tXTAX;
    }

    @JsonProperty("TX_TAX_RETURN_BASE")
    public TxValue getTXTAXRETURNBASE() {

        return txTaxReturnBase;
    }

    @JsonProperty("TX_TAX_RETURN_BASE")
    public void setTXTAXRETURNBASE(TxValue tXTAXRETURNBASE) {

        this.txTaxReturnBase = tXTAXRETURNBASE;
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this).append("tXVALUE", txValue).append("tXTAX", txTax).append("tXTAXRETURNBASE",
                txTaxReturnBase).toString();
    }

}

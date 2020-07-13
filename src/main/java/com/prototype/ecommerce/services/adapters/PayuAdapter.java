package com.prototype.ecommerce.services.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.prototype.ecommerce.model.dtos.OrderDto;
import com.prototype.ecommerce.model.paymentpojos.paymentrequest.*;
import com.prototype.ecommerce.model.paymentpojos.refundrequest.RefundMerchant;
import com.prototype.ecommerce.model.paymentpojos.refundrequest.RefundOrder;
import com.prototype.ecommerce.model.paymentpojos.refundrequest.RefundRequestPayu;
import com.prototype.ecommerce.model.paymentpojos.response.PaymentResponsePayu;
import com.prototype.ecommerce.utils.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class PayuAdapter implements PaymentAdapter {

	private static final String API_KEY = "4Vj8eK4rloUd272L48hsrarnUA";

	private static final String API_LOGIN = "pRRXKOl8ikMmt9u";

	private static final String ACCOUNT_ID = "512321";

	private static final String MERCHANT_ID = "508029";

	@Override public PaymentPayU createPaymentRequest(OrderDto data) {

		Address billingAddress = new Address(data.getPayer().getBillingAddress().getStreet1(),
				data.getPayer().getBillingAddress().getStreet2(), data.getPayer().getBillingAddress().getState(),
				data.getPayer().getBillingAddress().getCity(), "CO",
				String.valueOf(data.getPayer().getBillingAddress().getPostalCode()),
				String.valueOf(data.getPayer().getPhone()));
		Payer payer = new Payer(data.getPayer().getEmail(), data.getPayer().getName(), data.getPayer().getEmail(),
				data.getPayer().getPhone(), data.getPayer().getDniNumber(),
				billingAddress);
		Address shippingAddress = new Address(data.getShippingAddress().getStreet1(),
				data.getShippingAddress().getStreet2(), data.getShippingAddress().getState(),
				data.getShippingAddress().getCity(), "CO", String.valueOf(data.getShippingAddress().getPostalCode()),
				String.valueOf(data.getBuyerPhone()));
		Buyer buyer = new Buyer(data.getUser().getEmail(), data.getBuyerName(), data.getUser().getEmail(),
				String.valueOf(data.getBuyerPhone()), String.valueOf(data.getBuyerDniNumber()), shippingAddress);
		AdditionalValues additionalValues = new AdditionalValues(new TxValue(data.getTotal(), "COP"),
				new TxValue(0, "COP"), new TxValue(0, "COP"));
		Order order = new Order(ACCOUNT_ID, String.valueOf(data.getId()), "Redonez payment", "es",
				StringUtils
						.getMD5Hash(API_KEY + "~" + MERCHANT_ID + "~" + data.getId() + "~" + data.getTotal() + "~COP"),
				"", additionalValues, buyer);
		CreditCard card = new CreditCard(data.getPayer().getCardNumber(), data.getPayer().getCardSecurityCode(),
				data.getPayer().getCardExpirationDate(), data.getPayer().getCardHolderName());
		Transaction transaction = new Transaction(order, payer, card, "AUTHORIZATION_AND_CAPTURE",
				data.getPayer().getCardFranchise(), "CO", "127.0.0.1", "127.0.0.1", "DFAS",
				"Mozilla/5.0 (Windows NT 5.1; rv:18.0) Gecko/20100101 Firefox/18.0");

		return new PaymentPayU("es", "SUBMIT_TRANSACTION", new Merchant(API_KEY, API_LOGIN), transaction,
				true);
	}

	@Override public PaymentResponsePayu adaptPaymentResponse(String response) throws JsonProcessingException {

		XmlMapper xmlMapper = new XmlMapper();
		System.out.println(response);
		return xmlMapper.readValue(response, PaymentResponsePayu.class);
	}

	@Override public RefundRequestPayu createRefundRequest(com.prototype.ecommerce.model.Order order) {

		RefundMerchant refundMerchant = new RefundMerchant(API_KEY, API_LOGIN);
		com.prototype.ecommerce.model.paymentpojos.refundrequest.Transaction transaction = new com.prototype.ecommerce.model.paymentpojos.refundrequest.Transaction(
				new RefundOrder(order.getPaymentOrderId().trim()),
				"REFUND", "CLIENT REQUEST", order.getTransactionId().trim());
		return new RefundRequestPayu("es", "SUBMIT_TRANSACTION", refundMerchant, transaction, true);
	}

}

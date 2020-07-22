/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.services.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prototype.ecommerce.model.Address;
import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.model.Product;
import com.prototype.ecommerce.model.User;
import com.prototype.ecommerce.model.dtos.OrderDto;
import com.prototype.ecommerce.model.dtos.Payer;
import com.prototype.ecommerce.model.paymentpojos.response.PaymentResponsePayu;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test cases for the {@link PayuAdapter} class.
 *
 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
class PayuAdapterTest {

	/**
	 * Adapter to test.
	 */
	private final PayuAdapter payuAdapter = new PayuAdapter();

	/**
	 * Test the {@linkplain PayuAdapter#createPaymentRequest(OrderDto)} method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void createPaymentRequest() {

		payuAdapter.setAccountId("512321");
		payuAdapter.setApiKey("4Vj8eK4rloUd272L48hsrarnUA");
		payuAdapter.setApiLogin("pRRXKOl8ikMmt9u");
		payuAdapter.setMerchantId("508029");
		Address address = new Address("carrera 2", "casa 1", "Bogota", "BogotaDC", 1233);
		Product p = new Product(11, "PRODUCT1", "Product desc", 100, 15000);
		User u = new User("Nicolas", "HJGUJ", "nicoga97@gmail.com", "ROLE_ADMIN");
		Payer payer = new Payer("Nicolas", "nicoga97@gmail.com", "6778889", "345677", address, "563836378363", "234",
				"2021/12", "NICOLAS GARCIA", "VISA");
		OrderDto orderDto = new OrderDto(0, "APPROVED", 150000, new Date(), "hdewhj786dwedfw", "bxwjghdv234gvg3hf3",
				10, "Nicolas", "536373", "45677890", address, payer, p, u);
		String request = "{"
				+ "\"language\":\"es\","
				+ "\"command\":\"SUBMIT_TRANSACTION\","
				+ "\"merchant\":{"
				+ "\"apiKey\":\"4Vj8eK4rloUd272L48hsrarnUA\","
				+ "\"apiLogin\":\"pRRXKOl8ikMmt9u\""
				+ "},"
				+ "\"transaction\":{"
				+ "\"order\":{"
				+ "\"accountId\":\"512321\","
				+ "\"referenceCode\":\"0\","
				+ "\"description\":\"Redonez payment\","
				+ "\"language\":\"es\","
				+ "\"signature\":\"0992a9ac78b07481fa924c365d7d69f8\","
				+ "\"notifyUrl\":\"\","
				+ "\"additionalValues\":{"
				+ "\"TX_VALUE\":{"
				+ "\"value\":150000.0,"
				+ "\"currency\":\"COP\""
				+ "},"
				+ "\"TX_TAX\":{"
				+ "\"value\":0.0,"
				+ "\"currency\":\"COP\""
				+ "},"
				+ "\"TX_TAX_RETURN_BASE\":{"
				+ "\"value\":0.0,"
				+ "\"currency\":\"COP\""
				+ "}"
				+ "},"
				+ "\"buyer\":{"
				+ "\"merchantBuyerId\":\"nicoga97@gmail.com\","
				+ "\"fullName\":\"Nicolas\","
				+ "\"emailAddress\":\"nicoga97@gmail.com\","
				+ "\"contactPhone\":\"45677890\","
				+ "\"dniNumber\":\"536373\","
				+ "\"shippingAddress\":{"
				+ "\"street1\":\"carrera 2\","
				+ "\"street2\":\"casa 1\","
				+ "\"city\":\"Bogota\","
				+ "\"state\":\"BogotaDC\","
				+ "\"country\":\"CO\","
				+ "\"postalCode\":\"1233\","
				+ "\"phone\":\"45677890\""
				+ "}"
				+ "}"
				+ "},"
				+ "\"payer\":{"
				+ "\"merchantPayerId\":\"nicoga97@gmail.com\","
				+ "\"fullName\":\"Nicolas\","
				+ "\"emailAddress\":\"nicoga97@gmail.com\","
				+ "\"contactPhone\":\"6778889\","
				+ "\"dniNumber\":\"345677\","
				+ "\"billingAddress\":{"
				+ "\"street1\":\"carrera 2\","
				+ "\"street2\":\"casa 1\","
				+ "\"city\":\"Bogota\","
				+ "\"state\":\"BogotaDC\","
				+ "\"country\":\"CO\","
				+ "\"postalCode\":\"1233\","
				+ "\"phone\":\"6778889\""
				+ "}"
				+ "},"
				+ "\"creditCard\":{"
				+ "\"number\":\"563836378363\","
				+ "\"securityCode\":\"234\","
				+ "\"expirationDate\":\"2021/12\","
				+ "\"name\":\"NICOLAS GARCIA\""
				+ "},"
				+ "\"type\":\"AUTHORIZATION_AND_CAPTURE\","
				+ "\"paymentMethod\":\"VISA\","
				+ "\"paymentCountry\":\"CO\","
				+ "\"deviceSessionId\":\"127.0.0.1\","
				+ "\"ipAddress\":\"127.0.0.1\","
				+ "\"cookie\":\"DFAS\","
				+ "\"userAgent\":\"Mozilla/5.0 (Windows NT 5.1; rv:18.0) Gecko/20100101 Firefox/18.0\""
				+ "},"
				+ "\"test\":true"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = " ";
		try {
			jsonString = mapper.writeValueAsString(payuAdapter.createPaymentRequest(orderDto));
		} catch (JsonProcessingException e) {
			Assert.fail();
		}
		Assert.assertEquals(request, jsonString);
	}

	/**
	 * Test the {@linkplain PayuAdapter#adaptPaymentResponse(String)}  method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void adaptPaymentResponse() {

		String response = "<paymentResponse>"
				+ "<code>SUCCESS</code>"
				+ "<transactionResponse>"
				+ "<orderId>120244079</orderId>"
				+ "<transactionId>44671a74-6e62-488d-997f-01f36c145418</transactionId>"
				+ "<state>APPROVED</state>"
				+ "<paymentNetworkResponseCode>81</paymentNetworkResponseCode>"
				+ "<trazabilityCode>CRED - 666291213</trazabilityCode>"
				+ "<authorizationCode>417032</authorizationCode>"
				+ "<responseCode>APPROVED</responseCode>"
				+ "<responseMessage>Approved by the merchant</responseMessage>"
				+ "<operationDate>2020-07-10T13:16:58</operationDate>"
				+ "<extraParameters>"
				+ "<entry>"
				+ "<string>BANK_REFERENCED_CODE</string>"
				+ "<string>CREDIT</string>"
				+ "</entry>"
				+ "</extraParameters>"
				+ "<additionalInfo>"
				+ "<paymentNetwork>CREDIBANCO</paymentNetwork>"
				+ "<rejectionType>NONE</rejectionType>"
				+ "<cardType>CREDIT</cardType>"
				+ "<transactionType>AUTHORIZATION_AND_CAPTURE</transactionType>"
				+ "</additionalInfo>"
				+ "</transactionResponse>"
				+ "</paymentResponse>";
		PaymentResponsePayu adaptedResponse = null;
		try {
			adaptedResponse = payuAdapter.adaptPaymentResponse(response);
		} catch (JsonProcessingException e) {
			Assert.fail();
		}
		Assert.assertEquals("APPROVED", adaptedResponse.getTxStatus());
		Assert.assertEquals("SUCCESS", adaptedResponse.getStatus());
		Assert.assertEquals("44671a74-6e62-488d-997f-01f36c145418",
				adaptedResponse.getTransactionResponse().getTransactionId());

	}

	/**
	 * Test the {@linkplain PayuAdapter#createRefundRequest(Order)}  method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void createRefundRequest() {

		payuAdapter.setAccountId("512321");
		payuAdapter.setApiKey("4Vj8eK4rloUd272L48hsrarnUA");
		payuAdapter.setApiLogin("pRRXKOl8ikMmt9u");
		payuAdapter.setMerchantId("508029");
		Order order = new Order();
		order.setTransactionId("44671a74-6e62-488d-997f-01f36c145418");
		order.setPaymentOrderId("120244079");
		String refundRequest = "{"
				+ "\"language\":\"es\","
				+ "\"command\":\"SUBMIT_TRANSACTION\","
				+ "\"merchant\":{"
				+ "\"apiKey\":\"4Vj8eK4rloUd272L48hsrarnUA\","
				+ "\"apiLogin\":\"pRRXKOl8ikMmt9u\""
				+ "},"
				+ "\"transaction\":{"
				+ "\"order\":{"
				+ "\"id\":\"120244079\""
				+ "},"
				+ "\"type\":\"REFUND\","
				+ "\"reason\":\"CLIENT REQUEST\","
				+ "\"parentTransactionId\":\"44671a74-6e62-488d-997f-01f36c145418\""
				+ "},"
				+ "\"test\":true}";
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = " ";
		try {
			jsonString = mapper.writeValueAsString(payuAdapter.createRefundRequest(order));
		} catch (JsonProcessingException e) {
			Assert.fail();
		}
		assertEquals(refundRequest, jsonString);
	}
}
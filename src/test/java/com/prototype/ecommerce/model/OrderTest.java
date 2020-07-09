/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.model;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test cases for the {@link Order} class
 *
 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
public class OrderTest {

	/**
	 * Test the {@linkplain Order#getTotal()} method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	public void testGetOrderTotal() {

		float leftLimit = 1F;
		float rightLimit = 10F;
		float generatedPrice = leftLimit + new Random().nextFloat() * (rightLimit - leftLimit);
		int generateUnits = new Random().nextInt();
		Product p = new Product(1, "PRODUCT1", "Product desc", 100, generatedPrice);
		Order o = new Order(2, "APROVED", 0, new Date(),
				"ghjkkj", "klhjk", generateUnits, p, new User(), "34235432", "345345",
				new Address("EWRDWE", "PTO301", "BOGOTA", "BOGOTADC", 4565));
		assertThat(o.getTotal()).isEqualTo(generatedPrice * generateUnits);

	}

}

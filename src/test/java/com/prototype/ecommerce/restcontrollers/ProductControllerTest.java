/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.restcontrollers;

import com.prototype.ecommerce.model.Product;
import com.prototype.ecommerce.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.when;

/**
 * Unit test cases for the {@link ProductController} class
 *
 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

	/**
	 * Instance of the tested class.
	 */
	@InjectMocks
	ProductController productController;

	/**
	 * Mocked service used in {@linkplain ProductController}.
	 */
	@Mock
	ProductService productService;

	/**
	 * Test the {@linkplain ProductController#getProductsHandler()} method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void getProductsHandlerTest() {

		Product p = new Product(2, "Product1", "Description example", 100, 15000);
		Product p2 = new Product(1, "Product2", "Description example", 22, 10000);
		ArrayList<Product> products = new ArrayList<>();
		products.add(p);
		products.add(p2);
		when(productService.getProducts()).thenReturn(products);
		assertEquals(products, productController.getProductsHandler().getBody());
	}

	/**
	 * Test the {@linkplain ProductController#createProductHandler(Product)} method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void createProductHandlerTest() {

		Product p = new Product(1, "Product1", "Description example", 100, 15000);
		when(productService.createProduct(any(Product.class))).then(returnsFirstArg());
		assertEquals(p, productController.createProductHandler(p).getBody());
	}

	/**
	 * Test the {@linkplain ProductController#updateProductHandler(Product)}  method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void updateProductHandlerTest() {

		Product p = new Product(1, "Product1", "Description example", 100, 15000);
		when(productService.updateProduct(any(Product.class))).then(returnsFirstArg());
		assertEquals(p, productController.updateProductHandler(p).getBody());
	}
}
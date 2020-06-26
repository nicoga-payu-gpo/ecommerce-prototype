/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.services;

import com.prototype.ecommerce.model.Product;
import com.prototype.ecommerce.repositories.ProductRepository;
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
 * Unit test cases for the {@link OrderServiceImpl} class.
 *
 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
	/**
	 * Mocked repository used in {@linkplain ProductServiceImpl}.
	 */
	@Mock
	private ProductRepository productRepository;

	/**
	 * Instance of the tested class.
	 */
	@InjectMocks
	private ProductServiceImpl productService;

	/**
	 * Test the {@linkplain ProductServiceImpl#createProduct(Product)} method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void createProductTest() {

		Product p = new Product("dfgdfg", "Product1", "Description example", 100, 15000);
		when(productRepository.save(any(Product.class))).then(returnsFirstArg());
		assertEquals(p, productService.createProduct(p));
	}

	/**
	 * Test the {@linkplain ProductServiceImpl#getProducts()} method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void getProductsTest() {

		Product p = new Product("dfgdfg", "Product1", "Description example", 100, 15000);
		Product p2 = new Product("dfgdfdffg", "Product2", "Description example", 22, 10000);
		ArrayList<Product> products = new ArrayList<>();
		products.add(p);
		products.add(p2);
		when(productRepository.findAll()).thenReturn(products);
		assertEquals(products, productService.getProducts());
	}

	/**
	 * Test the {@linkplain ProductServiceImpl#updateProduct(Product)} method.
	 *
	 * @author Nicolas Garcia Rey (nicolas.garcia@payulatam.com)
	 * @date 25/06/2020
	 */
	@Test
	void updateProductTest() {

		Product p = new Product("dfgdfg", "Product1", "Description ", 10, 15000);
		when(productRepository.save(any(Product.class))).then(returnsFirstArg());
		assertEquals(p, productService.updateProduct(p));
	}
}
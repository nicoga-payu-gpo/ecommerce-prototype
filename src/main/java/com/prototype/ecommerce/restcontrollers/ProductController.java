/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.restcontrollers;

import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.model.Product;
import com.prototype.ecommerce.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for the platform products.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@RequestMapping("API/products")
@RestController
public class ProductController {

	/**
	 * The CRUD service for the entity {@linkplain Product}
	 */
	private final ProductService productService;

	public ProductController(ProductService productService) {

		this.productService = productService;
	}

	/**
	 * Returns all the products in the platform.
	 *
	 * @return All the products in the platform.
	 */
	@GetMapping
	public ResponseEntity<Iterable<Product>> getProductsHandler() {

		try {

			return new ResponseEntity<>(productService.getProducts(), HttpStatus.ACCEPTED);
		} catch (Exception ex) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Creates a new order in the platform.
	 *
	 * @param product Order to create.
	 * @return Created order.
	 */
	@PostMapping
	public ResponseEntity<Product> createProductHandler(@RequestBody Product product) {

		try {

			return new ResponseEntity<>(productService.createProduct(product), HttpStatus.ACCEPTED);
		} catch (Exception ex) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Update an existing product.
	 *
	 * @param product product with the updated values.
	 * @return Updated product.
	 */
	@PutMapping
	public ResponseEntity<Product> updateProductHandler(@RequestBody Product product) {
		try {

			return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.ACCEPTED);
		} catch (Exception ex) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

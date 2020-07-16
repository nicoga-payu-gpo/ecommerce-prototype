/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.restcontrollers;

import com.prototype.ecommerce.model.Product;
import com.prototype.ecommerce.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
	 * Logger class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	/**
	 * The CRUD service for the entity {@linkplain Product}
	 */
	private final ProductService productService;

	/**
	 * The overload constructor method of class.
	 *
	 * @param productService The product service.
	 */
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

		LOGGER.info("Get products handler invoked");
		try {

			return new ResponseEntity<>(productService.getProducts(), HttpStatus.ACCEPTED);
		} catch (Exception ex) {
			LOGGER.error("Error while fetching products caused by:{}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Creates a new order in the platform.
	 *
	 * @param product Order to create.
	 * @return Created order.
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<Product> createProductHandler(@RequestBody Product product) {

		LOGGER.info("Create product handler invoked");
		try {

			return new ResponseEntity<>(productService.createProduct(product), HttpStatus.ACCEPTED);
		} catch (Exception ex) {
			LOGGER.error("Error while creating the product caused by:{}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Update an existing product.
	 *
	 * @param product product with the updated values.
	 * @return Updated product.
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping
	public ResponseEntity<Product> updateProductHandler(@RequestBody Product product) {

		LOGGER.info("Update product handler invoked");
		try {

			return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.ACCEPTED);
		} catch (Exception ex) {
			LOGGER.error("Error while updating the product caused by:{}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Delete an existing product.
	 *
	 * @param id id of the product to delete.
	 * @return Confirmation response.
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProductHandler(@PathVariable String id) {

		LOGGER.info("Delete product handler invoked");
		try {
			productService.deleteProduct(Integer.parseInt(id));
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception ex) {
			LOGGER.error("Error while deleting the product caused by:{}", ex.getMessage());
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}

/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.services;

import com.prototype.ecommerce.model.Product;

/**
 * Service that exposes functionalities to manipulate {@linkplain Product} entities
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
public interface ProductService {

	/**
	 * Create a new product.
	 *
	 * @param product new product.
	 * @return created product.
	 */
	Product createProduct(Product product);

	/**
	 * Return all the products of the platform.
	 *
	 * @return All the products of the platform.
	 */
	Iterable<Product> getProducts();

	/**
	 * Updates an existing product int the platform.
	 *
	 * @param product Product update.
	 * @return Updated product.
	 */
	Product updateProduct(Product product);
}

/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.services;

import com.prototype.ecommerce.model.Product;
import com.prototype.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

/**
 * Service implementation that exposes functionalities to manipulate {@linkplain Product} entities.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

	/**
	 * {@linkplain Product} entities JPA repository.
	 */
	private final ProductRepository productRepository;

	/**
	 * Service constructor.
	 *
	 * @param productRepository Reference to the JPA repository.
	 */
	public ProductServiceImpl(ProductRepository productRepository) {

		this.productRepository = productRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public Product createProduct(Product product) {

		return productRepository.save(product);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public Iterable<Product> getProducts() {

		return productRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public Product updateProduct(Product product) {

		return productRepository.save(product);
	}
}

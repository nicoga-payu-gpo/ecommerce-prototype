/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.services.servicesImpl;

import com.prototype.ecommerce.model.Product;
import com.prototype.ecommerce.repositories.ProductRepository;
import com.prototype.ecommerce.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	 * Logger class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

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

		Product entity = productRepository.save(product);
		LOGGER.info("Product:{} successfully saved on the DB.", entity);
		return entity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public Iterable<Product> getProducts() {

		Iterable<Product> products = productRepository.findAll();
		LOGGER.info("Products fetched from the DB.");
		return products;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public Product updateProduct(Product product) {

		Product entity = productRepository.save(product);
		LOGGER.info("Product with id:{} successfully updated to: {} in the DB.", product.getId(), entity);
		return entity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public void deleteProduct(int id) {

		Product p = new Product();
		p.setId(id);
		productRepository.delete(p);
		LOGGER.info("Product with id:{} successfully deleted of the DB.",id);
	}
}

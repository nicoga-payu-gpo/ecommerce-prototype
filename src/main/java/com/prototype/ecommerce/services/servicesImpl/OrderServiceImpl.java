/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.services.servicesImpl;

import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.model.dtos.OrderDto;
import com.prototype.ecommerce.repositories.OrderRepository;
import com.prototype.ecommerce.restcontrollers.OrderController;
import com.prototype.ecommerce.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Service implementation that exposes functionalities to manipulate {@linkplain Order} entities
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

	/**
	 * Logger class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	/**
	 * {@linkplain Order} entities JPA repository.
	 */
	private final OrderRepository orderRepository;

	/**
	 * Service constructor.
	 *
	 * @param orderRepository Reference to the JPA repository.
	 */
	public OrderServiceImpl(OrderRepository orderRepository) {

		this.orderRepository = orderRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public Order createOrder(OrderDto order) {

		Order entity = orderRepository.save(new Order(order.getId(), order.getState(), order.getTotal(), new Date(),
				order.getTransactionId(), order.getPaymentOrderId(), order.getUnits(), order.getProduct(),
				order.getUser(), order.getBuyerDniNumber(), order.getBuyerPhone(), order.getShippingAddress()));
		LOGGER.info("Order:{} successfully saved on the DB.", entity);
		return entity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public Iterable<Order> getOrders() {

		Iterable<Order> orders = orderRepository.findAll();
		LOGGER.info("Orders fetched from the DB.");
		return orders;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public Order getOrdersById(String id) {

		Order order = orderRepository.getOrderById(Integer.parseInt(id));
		if (order != null) {
			LOGGER.info("Order with id:{} successfully fetched from the DB.", id);
		} else {
			LOGGER.warn("Order with id:{} was not founded in the DB.", id);
		}
		return order;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public Order updateOrder(Order order) {

		Order entity = orderRepository.save(order);
		LOGGER.info("Order with id:{} successfully updated to: {} in the DB.", order.getId(), entity);
		return entity ;
	}

}

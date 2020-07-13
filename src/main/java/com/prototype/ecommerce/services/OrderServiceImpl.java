/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.services;

import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.model.dtos.OrderDto;
import com.prototype.ecommerce.repositories.OrderRepository;
import org.springframework.stereotype.Service;

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

		Order entity = orderRepository
				.save(new Order(order.getId(), order.getState(), order.getTotal(), order.getDate(),
						order.getTransactionId(), order.getPaymentOrderId(), order.getUnits(), order.getProduct(),
						order.getUser(), order.getBuyerDniNumber(), order.getBuyerPhone(), order.getShippingAddress()));
		return orderRepository.save(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public Iterable<Order> getOrders() {

		return orderRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public Order getOrdersById(String id) {

		return orderRepository.getOrderById(Integer.parseInt(id));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public Order updateOrder(Order order) {

		return orderRepository.save(order);
	}

}

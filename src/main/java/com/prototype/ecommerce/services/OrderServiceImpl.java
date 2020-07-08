/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.services;

import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.model.User;
import com.prototype.ecommerce.model.dtos.OrderDto;
import com.prototype.ecommerce.model.paymentpojos.Payment;
import com.prototype.ecommerce.repositories.OrderRepository;
import com.prototype.ecommerce.restClient.PaymentClient;
import com.prototype.ecommerce.services.adapters.OrderAdapter;
import com.prototype.ecommerce.services.adapters.PaymentAdapter;
import org.springframework.stereotype.Service;

import java.util.Collection;

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
	 * Adapter for payment request creation.
	 */
	private final PaymentAdapter paymentAdapter;

	/**
	 * Order adapter in order to convert an {@linkplain OrderDto} into a {@linkplain Order} entity.
	 */
	private final OrderAdapter orderAdapter;

	/**
	 * Client that consumes the payment API.
	 */
	private final PaymentClient paymentClient;

	/**
	 * Service constructor.
	 *
	 * @param orderRepository Reference to the JPA repository.
	 * @param paymentAdapter  Adapter for the payment request and response.
	 * @param orderAdapter    Order adapter.
	 * @param paymentClient   Payment client that consumes the payment API.
	 */
	public OrderServiceImpl(OrderRepository orderRepository,
			PaymentAdapter paymentAdapter, OrderAdapter orderAdapter,
			PaymentClient paymentClient) {

		this.orderRepository = orderRepository;
		this.paymentAdapter = paymentAdapter;
		this.orderAdapter = orderAdapter;
		this.paymentClient = paymentClient;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public Order createOrder(OrderDto order) {

		Order entity = orderRepository.save(orderAdapter.adaptOrder(order));
		try {
			order.setId(entity.getId());
			Payment requestBody = paymentAdapter.createPaymentRequest(order);
			System.out.println(paymentClient.doPayment(requestBody));
		} catch (Exception ex) {
			ex.printStackTrace();
		}


		return entity;
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
	@Override public Collection<Order> getOrdersByUser(String email) {

		return orderRepository.getOrdersByUser(new User("",email,""));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public Order updateOrder(Order order) {

		return orderRepository.save(order);
	}

}

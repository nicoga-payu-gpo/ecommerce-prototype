/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.repositories;

import com.prototype.ecommerce.model.Order;
import com.prototype.ecommerce.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Spring boot JPA data repository used tu access {@link Order} entities.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@Repository
public interface OrderRepository extends CrudRepository<Order,String> {

	Collection<Order> getOrdersByUser(User user);

}

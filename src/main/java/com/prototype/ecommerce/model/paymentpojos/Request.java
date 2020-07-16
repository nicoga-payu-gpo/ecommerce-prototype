/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.model.paymentpojos;

/**
 * POJO of a request to a payment service.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
public abstract class Request {

	/**
	 * Command to perform.
	 */
	protected String command;

	public String getCommand() {

		return command;
	}

	public void setCommand(String command) {

		this.command = command;
	}

}

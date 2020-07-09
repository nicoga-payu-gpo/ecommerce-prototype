/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.model.dtos;

import com.prototype.ecommerce.model.Address;
import com.prototype.ecommerce.model.Product;
import com.prototype.ecommerce.model.User;

import java.util.Date;

/**
 * Order dto definition.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
public class OrderDto {

	/**
	 * Order id.
	 */
	private int id;

	/**
	 * Status of the order
	 */
	private String state;

	/**
	 * Total price of the item(s) in the order.
	 */
	private float total;

	/**
	 * Date in which the order was placed.
	 */
	private Date date;

	/**
	 * Payment transaction id.
	 */
	private String transactionId;

	/**
	 * Payment order id.
	 */
	private String paymentOrderId;

	/**
	 * Number of units of the product.
	 */
	private int units;

	/**
	 * Buyer DNI number.
	 */
	private String buyerDniNumber;

	/**
	 * Buyer phone number,
	 */
	private String buyerPhone;

	/**
	 * Shipping address for the order.
	 */
	private Address shippingAddress;

	/**
	 * Payer details.
	 */
	private Payer payer;

	/**
	 * Product that is going to be purchased.
	 */
	private Product product;

	/**
	 * User that owns the order.
	 */
	private User user;

	/**
	 * Order constructor,
	 *
	 * @param id              Id of the order.
	 * @param state           Status of the order.
	 * @param total           Total amount to pay in the order.
	 * @param date            Date in which the order was placed.
	 * @param transactionId   Transaction order Id provided by the payment service.
	 * @param paymentOrderId  Order id provided by the payment service.
	 * @param units           Units to purchase of the product in the order.
	 * @param buyerDniNumber  DNI number of the buyer.
	 * @param buyerPhone      Phone number of the buyer.
	 * @param shippingAddress Shipping address for the order.
	 * @param payer           Payer details.
	 * @param product         Product of the order
	 * @param user            User who owns the order.
	 */
	public OrderDto(int id, String state, float total, Date date, String transactionId, String paymentOrderId,
			int units,
			String buyerDniNumber, String buyerPhone, Address shippingAddress, Payer payer,
			Product product, User user) {

		this.id = id;
		this.state = state;
		this.total = total;
		this.date = date;
		this.transactionId = transactionId;
		this.paymentOrderId = paymentOrderId;
		this.units = units;
		this.buyerDniNumber = buyerDniNumber;
		this.buyerPhone = buyerPhone;
		this.shippingAddress = shippingAddress;
		this.payer = payer;
		this.product = product;
		this.user = user;
	}

	/**
	 * Constructor of an order.
	 *
	 * @param id             Id of the order.
	 * @param state          Current state of the order:
	 * @param total          Total amount to pay in the order based on the units of the product.
	 * @param date           Date of the order creation.
	 * @param transactionId  Transaction id given by payment process.
	 * @param paymentOrderId Payment order id given by the payment process.
	 * @param units          Number of the units of the product in the order.
	 * @param product        Product of the order.
	 * @param user           User who owns the order.
	 */
	public OrderDto(int id, String state, float total, Date date, String transactionId,
			String paymentOrderId, int units, Product product,
			User user) {

		this.id = id;
		this.state = state;
		this.total = total;
		this.date = date;
		this.transactionId = transactionId;
		this.paymentOrderId = paymentOrderId;
		this.units = units;
		this.product = product;
		this.user = user;
	}

	public OrderDto() {

	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getState() {

		return state;
	}

	public void setState(String state) {

		this.state = state;
	}

	public float getTotal() {

		return product.getPrice() * units;
	}

	public void setTotal(float total) {

		this.total = total;
	}

	public Date getDate() {

		return date;
	}

	public void setDate(Date date) {

		this.date = date;
	}

	public String getTransactionId() {

		return transactionId;
	}

	public void setTransactionId(String transactionId) {

		this.transactionId = transactionId;
	}

	public String getPaymentOrderId() {

		return paymentOrderId;
	}

	public void setPaymentOrderId(String paymentOrderId) {

		this.paymentOrderId = paymentOrderId;
	}

	public int getUnits() {

		return units;
	}

	public void setUnits(int units) {

		this.units = units;
	}

	public String getBuyerDniNumber() {

		return buyerDniNumber;
	}

	public void setBuyerDniNumber(String buyerDniNumber) {

		this.buyerDniNumber = buyerDniNumber;
	}

	public String getBuyerPhone() {

		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {

		this.buyerPhone = buyerPhone;
	}

	public Address getShippingAddress() {

		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {

		this.shippingAddress = shippingAddress;
	}

	public Payer getPayer() {

		return payer;
	}

	public void setPayer(Payer payer) {

		this.payer = payer;
	}

	public Product getProduct() {

		return product;
	}

	public void setProduct(Product product) {

		this.product = product;
	}

	public User getUser() {

		return user;
	}

	public void setUser(User user) {

		this.user = user;
	}

	@Override public String toString() {

		return "OrderDto{" +
				"id=" + id +
				", state='" + state + '\'' +
				", total=" + total +
				", date=" + date +
				", transactionId='" + transactionId + '\'' +
				", paymentOrderId='" + paymentOrderId + '\'' +
				", units=" + units +
				", buyerDniNumber=" + buyerDniNumber +
				", buyerPhone=" + buyerPhone +
				", shippingAddress=" + shippingAddress +
				", payer=" + payer +
				", product=" + product +
				", user=" + user +
				'}';
	}
}
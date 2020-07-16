/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Order definition.
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(schema="public",name="order")
public class Order implements Serializable {

	/**
	 * Order id.
	 */
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "order_id",
			unique = true)
	private int id;

	/**
	 * Status of the order
	 */
	@Column(name = "state")
	private String state;

	/**
	 * Total price of the item(s) in the order.
	 */
	@Column(name = "total")
	private float total;

	/**
	 * Date in which the order was placed.
	 */
	@Column(name = "date")
	private Date date;

	/**
	 * Payment transaction id.
	 */
	@Column(name = "transaction_id")
	private String transactionId;

	/**
	 * Payment order id.
	 */
	@Column(name = "payment_order_id")
	private String paymentOrderId;

	/**
	 * Number of units of the product.
	 */
	@Column(name = "units")
	private int units;

	/**
	 * Dni number of the buyer.
	 */
	@Column(name = "buyer_dni_number")
	private String buyerDniNumber;

	/**
	 * Buyer phone number.
	 */
	@Column(name = "buyer_phone")
	private String buyerPhone;

	/**
	 * Shipping address for the product in the order.
	 */
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "street1", column = @Column(name = "buyer_shipping_address_street1")),
			@AttributeOverride(name = "street2", column = @Column(name = "buyer_shipping_address_street2")),
			@AttributeOverride(name = "city", column = @Column(name = "buyer_shipping_address_city")),
			@AttributeOverride(name = "state", column = @Column(name = "buyer_shipping_address_state")),
			@AttributeOverride(name = "postalCode", column = @Column(name = "buyer_shipping_address_postal_code")),
	})
	private Address shippingAddress;

	/**
	 * Product that is going to be purchased.
	 */
	@JoinColumn(name = "product_id")
	@OneToOne
	private Product product;

	/**
	 * User that owns the order.
	 */
	@JoinColumn(name = "email")
	@OneToOne
	private User user;

	/**
	 * Public non argument constructor. Required by JPA framework.
	 */
	public Order() {
		//Do nothing
	}

	/**
	 * Constructor of an order.
	 *
	 * @param id Id of the order.
	 * @param state Current state of the order:
	 * @param total Total amount to pay in the order based on the units of the product.
	 * @param date Date of the order creation.
	 * @param transactionId Transaction id given by payment process.
	 * @param paymentOrderId Payment order id given by the payment process.
	 * @param units Number of the units of the product in the order.
	 * @param product Product of the order.
	 * @param user User who owns the order.
	 * @param buyerDniNumber Number of the user dni.
	 * @param buyerPhone Phone number of the buyer.
	 * @param shippingAddress Shipping address for the order.
	 */
	public Order(int id, String state, float total, Date date, String transactionId,
			String paymentOrderId, int units, Product product,
			User user, String buyerDniNumber, String buyerPhone, Address shippingAddress) {

		this.id = id;
		this.state = state;
		this.total = total;
		this.date = date;
		this.transactionId = transactionId;
		this.paymentOrderId = paymentOrderId;
		this.units = units;
		this.product = product;
		this.user = user;
		this.buyerDniNumber = buyerDniNumber;
		this.buyerPhone = buyerPhone;
		this.shippingAddress = shippingAddress;
	}

	public void setUser(User user) {

		this.user = user;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getState() {

		return state.trim();
	}

	public void setState(String state) {

		this.state = state;
	}

	public User getUser() {

		return user;
	}

	public float getTotal() {

		return product.getPrice()*units;
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

	public Product getProduct() {

		return product;
	}

	public void setProduct(Product product) {

		this.product = product;
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

	@Override public String toString() {

		return "Order{" +
				"id=" + id +
				", state='" + state + '\'' +
				", total=" + total +
				", date=" + date +
				", transactionId='" + transactionId + '\'' +
				", paymentOrderId='" + paymentOrderId + '\'' +
				", units=" + units +
				", buyerDniNumber='" + buyerDniNumber + '\'' +
				", buyerPhone='" + buyerPhone + '\'' +
				", shippingAddress=" + shippingAddress +
				", product=" + product +
				", user=" + user +
				'}';
	}

	@Override public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Order))
			return false;
		Order order = (Order) o;
		return id == order.id &&
				Float.compare(order.total, total) == 0 &&
				units == order.units &&
				Objects.equals(state, order.state) &&
				Objects.equals(date, order.date) &&
				Objects.equals(transactionId, order.transactionId) &&
				Objects.equals(paymentOrderId, order.paymentOrderId) &&
				Objects.equals(buyerDniNumber, order.buyerDniNumber) &&
				Objects.equals(buyerPhone, order.buyerPhone) &&
				Objects.equals(shippingAddress, order.shippingAddress) &&
				Objects.equals(product, order.product) &&
				Objects.equals(user, order.user);
	}

	@Override public int hashCode() {

		return Objects.hash(id, state, total, date, transactionId, paymentOrderId, units, buyerDniNumber, buyerPhone,
				shippingAddress, product, user);
	}
}

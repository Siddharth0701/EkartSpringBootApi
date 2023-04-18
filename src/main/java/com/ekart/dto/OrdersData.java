package com.ekart.dto;

import java.sql.Timestamp;
import java.util.List;

import com.ekart.model.Customer;
import com.ekart.model.OrderItem;

public class OrdersData {
	private long orderId;
	private Timestamp timestamp;
	private Customer customer;
	private List<OrderItem> orderItems;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}

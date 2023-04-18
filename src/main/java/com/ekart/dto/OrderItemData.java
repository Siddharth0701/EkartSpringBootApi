package com.ekart.dto;

import com.ekart.model.Product;

public class OrderItemData {
	private long orderItemId;
	private Product product;
	  private int quantity;
	  
	public OrderItemData() {
		super();
	}

	public long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	  


}

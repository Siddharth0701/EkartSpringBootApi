package com.ekart.dto;

public class CustomerData {
	private Long customerId;
	private String customerName;
	private String customerEmail;
	private String customerAddress;
	private String customerUserName;
	private String customerPassword;

	public CustomerData() {
		super();
	}
	
	

	public String getCustomerUserName() {
		return customerUserName;
	}



	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}



	public String getCustomerPassword() {
		return customerPassword;
	}



	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}



	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}




}

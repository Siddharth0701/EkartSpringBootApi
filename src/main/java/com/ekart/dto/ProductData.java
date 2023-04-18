package com.ekart.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ProductData {
	private Long productId;
	//name should not be null or empty
	//name should have at least 2 character
	@NotEmpty
	//@Size(min = 2,message = "Post productName should have at least 2 characters")
	private String productName;
	@NotEmpty
	private String productDescription;
	
	private double unitPrice;
	private String imageUrl;
	
	public ProductData() {
		super();
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
	

}

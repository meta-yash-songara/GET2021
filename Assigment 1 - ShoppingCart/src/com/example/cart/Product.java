package com.example.cart;

public class Product {
	private String productName;
	private int quantity;
	private double productPrice;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Product Details -----------\n" +
				"1. Name : " + productName + "\n" +
				"2. Quantity : " + quantity + "\n" +
				"3. Price : " + productPrice + "\n";
	}
	
	public Product(){}
	
	public Product(String productName, int quantity,
			double productPrice) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
}

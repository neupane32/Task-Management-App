package model;

import java.util.Date;

public class Order {
	private int orderId;
	private int userId;
	private int productId;
	private String orderDate;
	private String status;
	

	public Order(int orderId, int userId, int productId, String orderDate, String status) {

		this.orderId = orderId;
		this.userId = userId;
		this.productId = productId;
		this.orderDate = orderDate;
		this.status = status;

	}

	public Order(int userId, int productId, String orderDate, String status) {

		this.userId = userId;
		this.productId = productId;
		this.orderDate = orderDate;
		this.status = status;
	}
	
	private String customerName;
	private String productName;
	private Float productPrice;
	
	

	public Order(int orderId, String customerName, String orderDate, String productName, Float productPrice, String status) {

		this.orderId = orderId;
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.productName = productName;
		this.productPrice=productPrice;
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProdoctId() {
		return productId;
	}

	public void setProdoctId(int prodoctId) {
		this.productId = prodoctId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

}

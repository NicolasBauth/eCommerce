package com.spring.henallux.model;

public class Order 
{
	private Integer OrderId;
	private User customer;
	private java.util.Date orderDate;
	public Order()
	{
		
	}
	public Integer getOrderId() {
		return OrderId;
	}
	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}
	public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	public java.util.Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}
	
}

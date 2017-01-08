package com.spring.henallux.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.spring.henallux.model.OrderLine;

public class Order 
{
	private Integer OrderId;
	private User customer;
	private Date orderDate;

	private Collection<OrderLine> orderLines;
	
	public Order()
	{
		orderLines = new ArrayList<OrderLine>();
	}
	public Order(User customer){
		this.customer = customer;
		this.orderDate = new Date();
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
	public Collection<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(Collection<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	public void addOrderLine(OrderLine line){
		orderLines.add(line);
	}
	
}

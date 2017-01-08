package com.spring.henallux.model;

import java.math.BigDecimal;

public class OrderLine 
{
	private Integer OrderLineId;
	private Integer quantity;
	private BigDecimal unitPrice;
	private Product orderedProduct;
	private Order order;
	public OrderLine()
	{
		
	}
	public OrderLine(Order order, Product product, BigDecimal price, Integer qty){
		this.order = order;
		this.orderedProduct = product;
		this.unitPrice = price;
		this.quantity = qty;
	}
	public Integer getOrderLineId() {
		return OrderLineId;
	}
	public void setOrderLineId(Integer orderLineId) {
		OrderLineId = orderLineId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public java.math.BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(java.math.BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Product getOrderedProduct() {
		return orderedProduct;
	}
	public void setOrderedProduct(Product orderedProduct) {
		this.orderedProduct = orderedProduct;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
}

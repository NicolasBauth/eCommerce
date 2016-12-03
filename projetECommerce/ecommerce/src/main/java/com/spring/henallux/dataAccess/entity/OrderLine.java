package com.spring.henallux.dataAccess.entity;
import javax.persistence.*;
public class OrderLine 
{
	@Id
	@Column(name="numero")
	private Integer orderLineId;
	@Column(name="quantite")
	private Integer quantity;
	@Column(name="prixUnitaire")
	private java.math.BigDecimal unitPrice;
	@ManyToOne
	@Column(name="produitFK")
	ProductEntity orderedProduct;
	@ManyToOne
	@Column(name="commandeFK")
	OrderEntity order;
	public OrderLine()
	{
		
	}
	public Integer getOrderLineId() {
		return orderLineId;
	}
	public void setOrderLineId(Integer orderLineId) {
		this.orderLineId = orderLineId;
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
	public ProductEntity getOrderedProduct() {
		return orderedProduct;
	}
	public void setOrderedProduct(ProductEntity orderedProduct) {
		this.orderedProduct = orderedProduct;
	}
	public OrderEntity getOrder() {
		return order;
	}
	public void setOrder(OrderEntity order) {
		this.order = order;
	}
	
}

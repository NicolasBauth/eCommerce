package com.spring.henallux.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="commande")
public class OrderEntity 
{
	@Id
	@Column(name="numero")
	private Integer orderId;
	@Column(name="dateCommande")
	private java.util.Date orderDate;
	@ManyToOne
	@JoinColumn(name="utilisateurFK", referencedColumnName="idUtilisateur")
	private UserEntity customer;
	public OrderEntity()
	{
		
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public java.util.Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}
	public UserEntity getCustomer() {
		return customer;
	}
	public void setCustomer(UserEntity customer) {
		this.customer = customer;
	}
	
}

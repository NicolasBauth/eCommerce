package com.spring.henallux.dataAccess.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="commande")
public class OrderEntity 
{
	@Id
	@GeneratedValue
	@Column(name="numero")
	private Integer orderId;
	@Column(name="datecommande")
	private java.util.Date orderDate;
	@ManyToOne
	@JoinColumn(name="id_utilisateur", referencedColumnName="idutilisateur")
	private UserEntity customer;
	@OneToMany(mappedBy="order")
	private Collection<OrderLineEntity> orderLines;
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
	public Collection<OrderLineEntity> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(Collection<OrderLineEntity> orderLines) {
		this.orderLines = orderLines;
	}
	
}

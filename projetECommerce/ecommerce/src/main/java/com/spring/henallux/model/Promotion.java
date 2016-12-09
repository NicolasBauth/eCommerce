package com.spring.henallux.model;

public class Promotion 
{
	private Integer promoId;
	private java.util.Date startDate;
	private java.util.Date endDate;
	private java.math.BigDecimal percentage;
	public Promotion()
	{
		
	}
	public Integer getPromoId() {
		return promoId;
	}
	public void setPromoId(Integer promoId) {
		this.promoId = promoId;
	}
	public java.util.Date getStartDate() {
		return startDate;
	}
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}
	public java.util.Date getEndDate() {
		return endDate;
	}
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}
	public java.math.BigDecimal getPercentage() {
		return percentage;
	}
	public void setPercentage(java.math.BigDecimal percentage) {
		this.percentage = percentage;
	}
	
}

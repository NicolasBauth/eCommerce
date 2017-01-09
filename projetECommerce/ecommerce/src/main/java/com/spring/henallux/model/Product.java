package com.spring.henallux.model;

import java.math.BigDecimal;
import java.util.Date;

public class Product 
{
	private Integer productId;
	private String name;
	private java.util.Date marketingDate;
	private BigDecimal unitPrice;
	private String quantityPerPack;
	private String description;
	private Integer storedQuantity;
	private Promotion promotion;
	private Category category;
	public Product()
	{
		
	}
	public boolean isPromotionValid(){
		if(getPromotion() == null)
			return false;
		
		Date now = new Date();
		if(promotion.getStartDate() == null || promotion.getStartDate().before(now)){
			if(promotion.getEndDate() ==  null || promotion.getEndDate().after(now)){
				return true;		
			}
		}
		return false;
	}
	public BigDecimal getPrixPromotion(){
		BigDecimal price = unitPrice;
		if(isPromotionValid()){
			BigDecimal cent = new BigDecimal(100);
			BigDecimal one = new BigDecimal(1);
			price = price.multiply(one.subtract(getPromotion().getPercentage().divide(cent)));
		}
		return price;
	}
	public Product(String name)
	{
		setName(name);
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public java.util.Date getMarketingDate() {
		return marketingDate;
	}
	public void setMarketingDate(java.util.Date marketingDate) {
		this.marketingDate = marketingDate;
	}
	public java.math.BigDecimal getUnitPrice() {
		return getPrixPromotion();
	}
	public java.math.BigDecimal getUnitBasePrice() {
		return unitPrice;
	}
	public void setUnitPrice(java.math.BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getQuantityPerPack() {
		return quantityPerPack;
	}
	public void setQuantityPerPack(String quantityPerPack) {
		this.quantityPerPack = quantityPerPack;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStoredQuantity() {
		return storedQuantity;
	}
	public void setStoredQuantity(Integer storedQuantity) {
		this.storedQuantity = storedQuantity;
	}
	public Promotion getPromotion() {
		return promotion;
	}
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}

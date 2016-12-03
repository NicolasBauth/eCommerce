package com.spring.henallux.dataAccess.entity;
import javax.persistence.*;

@Entity
@Table(name="produit")
public class ProductEntity 
{
	@Id
	@Column(name="idProduit")
	private Integer productId;
	@Column(name="nom")
	private String name;
	@Column(name="dateCommercialisation")
	private java.util.Date marketingDate;
	@Column(name="prixUnitaire")
	private java.math.BigDecimal unitPrice;
	@JoinColumn(name="fkPromo", referencedColumnName="idPromo")
	@ManyToOne
	private PromotionEntity promotion;
	public ProductEntity()
	{
		
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
		return unitPrice;
	}
	public void setUnitPrice(java.math.BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public PromotionEntity getPromotion() {
		return promotion;
	}
	public void setPromotion(PromotionEntity promotion) {
		this.promotion = promotion;
	}
	
}

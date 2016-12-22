package com.spring.henallux.dataAccess.entity;

import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="produit")
@NamedQueries({
	@NamedQuery(
			name = "findProductByCategoryCategoryId",
			query = "from ProductEntity p where p.category.categoryId = :categoryCategoryId"
			),
})

public class ProductEntity 
{
	@Id
	@Column(name="idproduit")
	private Integer productId;
	@Column(name="nom")
	private String name;
	@Column(name="datecommercialisation")
	private java.util.Date marketingDate;
	@Column(name="prixunitaire")
	private java.math.BigDecimal unitPrice;
	@Column(name="description")
	private String description;
	@Column(name="quantiteindividuelle")
	private String quantityPerPack;
	@Column(name="quantiteenstock")
	private Integer storedQuantity;
	@JoinColumn(name="id_promotion", referencedColumnName="idpromo")
	@ManyToOne
	private PromotionEntity promotion;
	@JoinColumn(name="id_categorie",referencedColumnName="idcategorie")
	@ManyToOne
	private CategoryEntity category;
	
	@OneToMany(mappedBy="referencedProduct")
	private Collection<ImageEntity> images;
	@OneToMany(mappedBy="orderedProduct")
	private Collection<OrderLineEntity> orderLines;
	
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
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQuantityPerPack() {
		return quantityPerPack;
	}
	public void setQuantityPerPack(String quantityPerPack) {
		this.quantityPerPack = quantityPerPack;
	}
	public Integer getStoredQuantity() {
		return storedQuantity;
	}
	public void setStoredQuantity(Integer storedQuantity) {
		this.storedQuantity = storedQuantity;
	}
	public Collection<ImageEntity> getImages() {
		return images;
	}
	public void setImages(Collection<ImageEntity> images) {
		this.images = images;
	}
	public Collection<OrderLineEntity> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(Collection<OrderLineEntity> orderLines) {
		this.orderLines = orderLines;
	}
	
	
	
}

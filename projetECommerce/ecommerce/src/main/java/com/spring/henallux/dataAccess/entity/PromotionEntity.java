package com.spring.henallux.dataAccess.entity;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="promotion")
@NamedQueries({
	@NamedQuery(
			name = "findPromotionByProduct",
			query = "from PromotionEntity p where p.promoId = :idPromo and p.startDate < :dateNow and p.endDate > :dateNow"
			),
})
public class PromotionEntity 
{
	@Id
	@Column(name="idpromo")
	private Integer promoId;
	@Column(name="datedeb")
	private java.util.Date startDate;
	@Column(name="datefin")
	private java.util.Date endDate;
	@Column(name="pourcentage")
	private java.math.BigDecimal percentage;
	@OneToMany(mappedBy="promotion")
	private Collection<ProductEntity> products;
	public PromotionEntity()
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

	public Collection<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(Collection<ProductEntity> products) {
		this.products = products;
	}
	
}

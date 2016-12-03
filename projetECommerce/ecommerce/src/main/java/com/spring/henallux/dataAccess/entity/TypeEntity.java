package com.spring.henallux.dataAccess.entity;
import javax.persistence.*;

@Entity
@Table(name="type")
public class TypeEntity 
{
	@Id
	@Column(name="idType")
	private Integer typeId;
	@JoinColumn(name="fkProduit", referencedColumnName="idProduit")
	@ManyToOne
	private ProductEntity product;
	@JoinColumn(name="fkCategorie", referencedColumnName="idcategorie")
	@ManyToOne
	private CategoryEntity category;
	public TypeEntity()
	{
		
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	
}

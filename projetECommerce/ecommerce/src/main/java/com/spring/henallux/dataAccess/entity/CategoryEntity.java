package com.spring.henallux.dataAccess.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categorie")
/*@NamedQueries({
	@NamedQuery(
			name = "findProductByCategoryCategoryId",
			query = "from ProductEntity p where p.category.categoryId = :categoryCategoryId"
			),
})*/

public class CategoryEntity 
{

	@Id
	@Column(name="idcategorie")
	private Integer categoryId;
	@Column(name="icon")
	private String icon;
	@OneToMany(mappedBy="category")
	private Collection<ProductEntity> productsOfCategory;
	@OneToMany(mappedBy="translatedCategory")
	private Collection<TranslationEntity> translations;
	public CategoryEntity()
	{
		
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Collection<ProductEntity> getProductsOfCategory() {
		return productsOfCategory;
	}
	public void setProductsOfCategory(Collection<ProductEntity> productsOfCategory) {
		this.productsOfCategory = productsOfCategory;
	}
	public Collection<TranslationEntity> getTranslations() {
		return translations;
	}
	public void setTranslations(Collection<TranslationEntity> translations) {
		this.translations = translations;
	}
	
}

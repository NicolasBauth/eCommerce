package com.spring.henallux.dataAccess.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categorie")
public class CategoryEntity 
{
	@Id
	@Column(name="idCategorie")
	private Integer categoryId;
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

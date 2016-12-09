package com.spring.henallux.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="traduction")
public class TranslationEntity 
{
	@Id
	@Column(name="idTraduction")
	private Integer translationId;
	@Column(name="libelle")
	private String categoryTranslation;
	@ManyToOne
	@JoinColumn(name="id_categorie",referencedColumnName="idCategorie")
	private CategoryEntity translatedCategory;
	@ManyToOne
	@JoinColumn(name="id_langue", referencedColumnName="idLangue")
	private LanguageEntity targetedLanguage;
	public TranslationEntity()
	{
		
	}
	public Integer getTranslationId() {
		return translationId;
	}
	public void setTranslationId(Integer translationId) {
		this.translationId = translationId;
	}
	public String getCategoryTranslation() {
		return categoryTranslation;
	}
	public void setCategoryTranslation(String categoryTranslation) {
		this.categoryTranslation = categoryTranslation;
	}
	public CategoryEntity getTranslatedCategory() {
		return translatedCategory;
	}
	public void setTranslatedCategory(CategoryEntity translatedCategory) {
		this.translatedCategory = translatedCategory;
	}
	public LanguageEntity getTargetedLanguage() {
		return targetedLanguage;
	}
	public void setTargetedLanguage(LanguageEntity targetedLanguage) {
		this.targetedLanguage = targetedLanguage;
	}
	
}

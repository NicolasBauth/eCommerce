package com.spring.henallux.model;

public class Translation 
{
	private Integer translationId;
	private String categoryTranslation;
	private Category translatedCategory;
	private Language targetedLanguage;
	public Translation()
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
	public Category getTranslatedCategory() {
		return translatedCategory;
	}
	public void setTranslatedCategory(Category translatedCategory) {
		this.translatedCategory = translatedCategory;
	}
	public Language getTargetedLanguage() {
		return targetedLanguage;
	}
	public void setTargetedLanguage(Language targetedLanguage) {
		this.targetedLanguage = targetedLanguage;
	}
	
}

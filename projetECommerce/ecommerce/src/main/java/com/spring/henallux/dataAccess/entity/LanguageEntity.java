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
@Table(name="langue")
@NamedQueries({
	@NamedQuery(
			name = "findLanguageByName",
			query = "from LanguageEntity l where l.name = :langue"
			),
})
public class LanguageEntity 
{
	@Id
	@Column(name="idlangue")
	private Integer languageId;
	@Column(name="nom")
	private String name;
	@OneToMany(mappedBy="targetedLanguage")
	private Collection<TranslationEntity> translations;
	public LanguageEntity()
	{
		
	}
	public Integer getLanguageId() {
		return languageId;
	}
	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<TranslationEntity> getTranslations() {
		return translations;
	}
	public void setTranslations(Collection<TranslationEntity> translations) {
		this.translations = translations;
	}
	
}

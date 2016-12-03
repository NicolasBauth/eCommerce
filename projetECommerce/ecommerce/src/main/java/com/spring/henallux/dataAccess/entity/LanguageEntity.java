package com.spring.henallux.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class LanguageEntity 
{
	@Id
	@Column(name="idLangue")
	private Integer languageId;
	@Column(name="nom")
	private String name;
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
	
}
package com.spring.henallux.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class CategoryEntity 
{
	@Id
	@Column(name="idcategorie")
	private Integer categoryId;
	public CategoryEntity()
	{
		
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
}

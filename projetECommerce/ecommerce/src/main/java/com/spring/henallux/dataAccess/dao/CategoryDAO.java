package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.CategoryEntity;
import com.spring.henallux.dataAccess.repository.CategoryRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Category;

@Service
@Transactional
public class CategoryDAO 
{
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProviderConverter providerConverter;
	
	public Category save(Category category)
	{
		CategoryEntity categoryEntity = providerConverter.categoryModelToCategoryEntity(category);
		categoryEntity = categoryRepository.save(categoryEntity);
		return providerConverter.categoryEntityToCategoryModel(categoryEntity);	
	}
	
	
	public ArrayList<Category> getAllCategories()
	{
		List<CategoryEntity> categoryEntities = categoryRepository.findAll();
		ArrayList<Category> categories = new ArrayList<Category>();
		for( CategoryEntity categoryEntity : categoryEntities)
		{
			Category category = providerConverter.categoryEntityToCategoryModel(categoryEntity);
			categories.add(category);
		}
		return categories;
		
	}
	
	
}

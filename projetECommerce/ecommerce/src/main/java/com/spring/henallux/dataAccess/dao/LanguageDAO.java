package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.LanguageEntity;
import com.spring.henallux.dataAccess.repository.LanguageRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Language;

@Service
@Transactional
public class LanguageDAO 
{
	@Autowired
	private LanguageRepository languageRepository;
	@Autowired
	private ProviderConverter providerConverter;
	public Language save(Language language)
	{
		LanguageEntity languageEntity = providerConverter.languageModelToLanguageEntity(language);
		languageEntity = languageRepository.save(languageEntity);
		return providerConverter.languageEntityToLanguageModel(languageEntity);
	}
	
	public ArrayList<Language> getAllLanguages()
	{
		
		List<LanguageEntity> languageEntities =  languageRepository.findAll();
		ArrayList<Language> languages = new ArrayList<Language>();
		for (LanguageEntity languageEntity : languageEntities)
		{
			Language language = providerConverter.languageEntityToLanguageModel(languageEntity);
			languages.add(language);
		}
		return languages;
	}
}

package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.TranslationEntity;
import com.spring.henallux.dataAccess.repository.TranslationRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Translation;

@Service
@Transactional
public class TranslationDAO 
{
	@Autowired
	private TranslationRepository translationRepository;
	@Autowired
	private ProviderConverter providerConverter;
	public Translation save(Translation translation)
	{
		TranslationEntity translationEntity = providerConverter.translationModelToTranslationEntity(translation);
		translationEntity = translationRepository.save(translationEntity);
		return providerConverter.translationEntityToTranslationModel(translationEntity);
	}
	
	public ArrayList<Translation> getAllTranslations()
	{
		List<TranslationEntity> translationEntities = translationRepository.findAll();
		ArrayList<Translation> translations = new ArrayList<Translation>();
		for(TranslationEntity translationEntity : translationEntities)
		{
			Translation translation = providerConverter.translationEntityToTranslationModel(translationEntity);
			translations.add(translation);
		}
		return translations;
	}
}

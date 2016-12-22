package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.ProductEntity;
import com.spring.henallux.dataAccess.entity.TranslationEntity;
import com.spring.henallux.dataAccess.repository.TranslationRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Product;
import com.spring.henallux.model.Translation;

@Service
@Transactional
public class TranslationDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private TranslationRepository translationRepository;
	@Autowired
	private ProviderConverter providerConverter;
	
	

	public ArrayList<Translation> findTranslationByTargetedLanguageLanguageId(Integer targetedLanguageLanguageId){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("findTranslationByTargetedLanguageLanguageId").setInteger("targetedLanguageLanguageId", targetedLanguageLanguageId);
		List<TranslationEntity> translationEntities = query.list();
		ArrayList<Translation> translations = new ArrayList<>();
		for(TranslationEntity entity : translationEntities){
			Translation product = providerConverter.translationEntityToTranslationModel(entity);
			translations.add(product);
		}
		session.getTransaction().commit();
		return translations;
	}
	
	public Translation findTranslationByTargetedLanguageLanguageIdAndTranslatedCategoryCategoryId(Integer targetedLanguageLanguageId, Integer translatedCategoryCategoryId){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("findTranslationByTargetedLanguageLanguageIdAndTranslatedCategoryCategoryId");
		query.setInteger("targetedLanguageLanguageId", targetedLanguageLanguageId);
		query.setInteger("translatedCategoryCategoryId", translatedCategoryCategoryId);
		List<TranslationEntity> translationEntities = query.list();
		Translation category = providerConverter.translationEntityToTranslationModel(translationEntities.get(0));

		session.getTransaction().commit();
		return category;
	}
	
	
	
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

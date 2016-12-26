package com.spring.henallux.dataAccess.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.TranslationEntity;
import com.spring.henallux.model.Translation;

@Repository
@Transactional
public interface TranslationRepository extends JpaRepository<TranslationEntity,Integer>{
//String REQUEST = "from TranslationEntity t inner join CategoryEntity c on c.categoryId = t.translatedCategory.categoryId where t.targetedLanguage.languageId = :idlang";
	
	//@Query(REQUEST)
	//public List<TranslationEntity> findLibelleCategorieByLangage(@Param("idlang")Integer idlang);
	
	public List<TranslationEntity> findTranslationByTargetedLanguageLanguageId(Integer targetedLanguageLanguageId);
	public TranslationEntity findTranslationByTargetedLanguageLanguageIdAndTranslatedCategoryCategoryId(Integer targetedLanguageLanguageId, Integer translatedCategoryCategoryId);
}

package com.spring.henallux.dataAccess.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.TranslationEntity;

@Repository
@Transactional
public interface TranslationRepository extends JpaRepository<TranslationEntity,Integer>{

}

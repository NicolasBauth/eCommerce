package com.spring.henallux.dataAccess.repository;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.PromotionEntity;

@Repository
@Transactional
public interface PromotionRepository extends JpaRepository<PromotionEntity,Integer>{
	//public List<PromotionEntity> findPromotionByProduct(Integer idPromo, Date dateNow);
}

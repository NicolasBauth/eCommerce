package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.PromotionEntity;
import com.spring.henallux.dataAccess.repository.PromotionRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Promotion;

@Service
@Transactional
public class PromotionDAO 
{
	@Autowired
	private PromotionRepository promotionRepository;
	@Autowired
	private ProviderConverter providerConverter;
	public Promotion save(Promotion promotion)
	{
		PromotionEntity promotionEntity = providerConverter.promotionModelToPromotionEntity(promotion);
		promotionEntity = promotionRepository.save(promotionEntity);
		return providerConverter.promotionEntityToPromotionModel(promotionEntity);
	}
	
	public ArrayList<Promotion> getAllPromotions()
	{
		List<PromotionEntity> promotionEntities = promotionRepository.findAll();
		ArrayList<Promotion> promotions = new ArrayList<Promotion>();
		for(PromotionEntity promotionEntity : promotionEntities)
		{
			Promotion promotion = providerConverter.promotionEntityToPromotionModel(promotionEntity);
			promotions.add(promotion);
		}
		return promotions;
				
	}
}

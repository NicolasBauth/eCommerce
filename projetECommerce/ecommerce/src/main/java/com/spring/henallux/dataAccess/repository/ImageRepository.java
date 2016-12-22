package com.spring.henallux.dataAccess.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.ImageEntity;
import com.spring.henallux.model.Product;



@Repository
@Transactional
public interface ImageRepository extends JpaRepository<ImageEntity,Integer>
{
	public List<ImageEntity> findFirstByReferencedProductProductId(Integer productId);
	public List<ImageEntity> findImageByReferencedProductProductId(Integer productId);
	
}

package com.spring.henallux.dataAccess.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.ProductEntity;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<ProductEntity,Integer>
{
	public List<ProductEntity> findTop12ByOrderByMarketingDateAsc();
	public List<ProductEntity> findProductByCategoryCategoryId(Integer categoryCategoryId);
	
}

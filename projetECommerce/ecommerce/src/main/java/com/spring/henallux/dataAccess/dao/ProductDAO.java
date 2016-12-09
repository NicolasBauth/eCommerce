package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.ProductEntity;
import com.spring.henallux.dataAccess.repository.ProductRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Product;

@Service
@Transactional
public class ProductDAO 
{
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProviderConverter providerConverter;
	public Product save(Product product)
	{
		ProductEntity productEntity = providerConverter.productModelToProductEntity(product);
		productEntity = productRepository.save(productEntity);
		return providerConverter.productEntityToProductModel(productEntity);
	}
	
	
	public ArrayList<Product> getAllProducts()
	{
		List<ProductEntity> productEntities = productRepository.findAll();
		ArrayList<Product> products = new ArrayList<Product>();
		for(ProductEntity productEntity : productEntities)
		{
			Product product = providerConverter.productEntityToProductModel(productEntity);
			products.add(product);
		}
		return products;
	}
}

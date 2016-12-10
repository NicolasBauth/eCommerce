package com.spring.henallux.dataAccess.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	private SessionFactory sessionFactory;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProviderConverter providerConverter;
	
	/*public ArrayList<Product> findProductByNewArrivals(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("findProductbyNewArrivals").setDate("date", new Date(0));
		List<ProductEntity> productEntities = query.list();
		ArrayList<Product> products = new ArrayList<>();
		for(ProductEntity entity : productEntities){
			Product product = providerConverter.productEntityToProductModel(entity);
			products.add(product);
		}
		session.getTransaction().commit();
		return products;
	}*/
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
		Product product = new Product("CacaPIPIhihiHAHA");
		products.add(product);
		System.out.println("ICI LA");
		for (Product v : products)
		      System.out.print(v.getName() + " HAHA ");
		System.out.println();
		return products;
	}
	Date s = new Date(0);
	Date e = new Date(0);
	
	//productRepository.findByStartDateBetween(s, e);
}

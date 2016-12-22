package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.ImageEntity;
import com.spring.henallux.dataAccess.entity.ProductEntity;
import com.spring.henallux.dataAccess.repository.ImageRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Image;
import com.spring.henallux.model.Product;

@Service
@Transactional
public class ImageDAO 
{
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private ProviderConverter providerConverter;
	
	
	public Image findImageByReferencedProductProductId(Integer productId){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("findFirstByReferencedProductProductId").setInteger("productId", productId);
		query.setMaxResults(1);
		List<ImageEntity> imageEntity = query.list();
		Image image = providerConverter.imageEntityToImageModel(imageEntity.get(0));
		
		session.getTransaction().commit();
		return image;
	}
	
	public ArrayList<Image> findImagesByReferencedProductProductId(Integer productId){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("findFirstByReferencedProductProductId").setInteger("productId", productId);
		List<ImageEntity> ImageEntities = query.list();
		ArrayList<Image> images = new ArrayList<Image>();
		for(ImageEntity imageEntity : ImageEntities){
			Image image = providerConverter.imageEntityToImageModel(imageEntity);
			images.add(image);
		}
		
		
		session.getTransaction().commit();
		return images;
	}
	
	public Image save(Image image)
	{
		ImageEntity imageEntity = providerConverter.imageModelToImageEntity(image);
		imageEntity = imageRepository.save(imageEntity);
		return providerConverter.imageEntityToImageModel(imageEntity);
	}
	
	public ArrayList<Image> getAllImages()
	{
		List<ImageEntity> imageEntities = imageRepository.findAll();
		ArrayList<Image> images = new ArrayList<Image>();
		for (ImageEntity imageEntity : imageEntities)
		{
			Image image = providerConverter.imageEntityToImageModel(imageEntity);
			images.add(image);
		}
		return images;
	}
}

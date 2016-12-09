package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.ImageEntity;
import com.spring.henallux.dataAccess.repository.ImageRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Image;

@Service
@Transactional
public class ImageDAO 
{
	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private ProviderConverter providerConverter;
	Image save(Image image)
	{
		ImageEntity imageEntity = providerConverter.imageModelToImageEntity(image);
		imageEntity = imageRepository.save(imageEntity);
		return providerConverter.imageEntityToImageModel(imageEntity);
	}
	
	ArrayList<Image> getAllImages()
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

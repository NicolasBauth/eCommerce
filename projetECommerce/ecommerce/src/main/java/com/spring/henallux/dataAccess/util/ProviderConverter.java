package com.spring.henallux.dataAccess.util;

import org.springframework.stereotype.Component;
import com.spring.henallux.model.*;
import com.spring.henallux.model.OrderLine;
import com.spring.henallux.dataAccess.entity.*;
@Component
public class ProviderConverter 
{
	public CategoryEntity categoryModelToCategoryEntity(Category categoryModel)
	{
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setCategoryId(categoryModel.getCategoryId());
		return categoryEntity;
	}
	
	
	public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity)
	{
		Category categoryModel = new Category();
		categoryModel.setCategoryId(categoryEntity.getCategoryId());
		return categoryModel;
	}
	
	
	public ImageEntity imageModelToImageEntity(Image imageModel)
	{
		ImageEntity imageEntity = new ImageEntity();
		imageEntity.setImageId(imageModel.getImageId());
		imageEntity.setName(imageModel.getName());
		imageEntity.setPath(imageModel.getPath());
		ProductEntity referencedProduct = productModelToProductEntity(imageModel.getReferencedProduct());
		imageEntity.setReferencedProduct(referencedProduct);
		return imageEntity;
	}
	
	
	public Image imageEntityToImageModel(ImageEntity imageEntity)
	{
		Image imageModel = new Image();
		imageModel.setImageId(imageEntity.getImageId());
		imageModel.setName(imageEntity.getName());
		imageModel.setPath(imageEntity.getPath());
		Product referencedProduct = productEntityToProductModel(imageEntity.getReferencedProduct());
		imageModel.setReferencedProduct(referencedProduct);
		return imageModel;
	}
	
	
	public LanguageEntity languageModelToLanguageEntity(Language languageModel)
	{
		LanguageEntity languageEntity = new LanguageEntity();
		languageEntity.setLanguageId(languageModel.getLanguageId());
		languageEntity.setName(languageModel.getName());
		return languageEntity;
	}
	
	
	public Language languageEntityToLanguageModel(LanguageEntity languageEntity)
	{
		Language languageModel = new Language();
		languageModel.setLanguageId(languageEntity.getLanguageId());
		languageModel.setName(languageEntity.getName());
		return languageModel;
	}
	
	public OrderEntity orderModelToOrderEntity(Order orderModel)
	{
		OrderEntity orderEntity = new OrderEntity();
		UserEntity customer = userModelToUserEntity(orderModel.getCustomer());
		orderEntity.setCustomer(customer);
		orderEntity.setOrderDate(orderModel.getOrderDate());
		orderEntity.setOrderId(orderModel.getOrderId());
		return orderEntity;
	}
	
	
	public Order orderEntityToOrderModel(OrderEntity orderEntity)
	{
		Order orderModel = new Order();
		User customer = userEntityToUserModel(orderEntity.getCustomer());
		orderModel.setCustomer(customer);
		orderModel.setOrderDate(orderEntity.getOrderDate());
		orderModel.setOrderId(orderEntity.getOrderId());
		return orderModel;
	}
	
	
	public OrderLineEntity orderLineModelToOrderLineEntity(OrderLine orderLineModel)
	{
		OrderLineEntity orderLineEntity = new OrderLineEntity();
		OrderEntity order = orderModelToOrderEntity(orderLineModel.getOrder());
		ProductEntity orderedProduct = productModelToProductEntity(orderLineModel.getOrderedProduct());
		orderLineEntity.setOrder(order);
		orderLineEntity.setOrderedProduct(orderedProduct);
		orderLineEntity.setOrderLineId(orderLineModel.getOrderLineId());
		orderLineEntity.setQuantity(orderLineModel.getQuantity());
		orderLineEntity.setUnitPrice(orderLineModel.getUnitPrice());
		return orderLineEntity;
	}
	
	
	/*public OrderLine orderLineEntityToOrderLineModel(OrderLineEntity orderLineEntity)
	{
		OrderLine orderLineModel = new OrderLine();
		Order order = orderEntityToOrderModel(orderLineEntity.getOrder());
		Product orderedProduct = productEntityToProductModel(orderLineEntity.getOrderedProduct());
		orderLineModel.setOrder(order);
		orderLineModel.setOrderedProduct(orderedProduct);
		orderLineModel.setOrderLineId(orderLineEntity.getOrderLineId());
		orderLineModel.setQuantity(orderLineEntity.getQuantity());
		orderLineModel.setUnitPrice(orderLineEntity.getUnitPrice());
		return orderLineModel;
	}*/
	
	
	public ProductEntity productModelToProductEntity(Product productModel)
	{
		ProductEntity productEntity = new ProductEntity();
		CategoryEntity category = categoryModelToCategoryEntity(productModel.getCategory());
		productEntity.setCategory(category);
		productEntity.setDescription(productModel.getDescription());
		productEntity.setMarketingDate(productModel.getMarketingDate());
		productEntity.setName(productModel.getName());
		productEntity.setProductId(productModel.getProductId());
		PromotionEntity promotion = promotionModelToPromotionEntity(productModel.getPromotion());
		productEntity.setPromotion(promotion);
		productEntity.setQuantityPerPack(productModel.getQuantityPerPack());
		productEntity.setStoredQuantity(productModel.getStoredQuantity());
		productEntity.setUnitPrice(productModel.getUnitPrice());
		return productEntity;
	}
	
	
	public Product productEntityToProductModel(ProductEntity productEntity)
	{
		Product productModel = new Product();
		Category category = categoryEntityToCategoryModel(productEntity.getCategory());
		productModel.setCategory(category);
		productModel.setDescription(productEntity.getDescription());
		productModel.setMarketingDate(productEntity.getMarketingDate());
		productModel.setName(productEntity.getName());
		productModel.setProductId(productEntity.getProductId());
		Promotion promotion = promotionEntityToPromotionModel(productEntity.getPromotion());
		productModel.setPromotion(promotion);
		productModel.setQuantityPerPack(productEntity.getQuantityPerPack());
		productModel.setStoredQuantity(productEntity.getStoredQuantity());
		productModel.setUnitPrice(productEntity.getUnitPrice());
		return productModel;
	}
	
	
	public PromotionEntity promotionModelToPromotionEntity(Promotion promotionModel)
	{
		PromotionEntity promotionEntity = new PromotionEntity();
		promotionEntity.setEndDate(promotionModel.getEndDate());
		promotionEntity.setPercentage(promotionModel.getPercentage());
		promotionEntity.setPromoId(promotionModel.getPromoId());
		promotionEntity.setStartDate(promotionModel.getStartDate());
		return promotionEntity;
	}
	
	
	public Promotion promotionEntityToPromotionModel(PromotionEntity promotionEntity)
	{
		Promotion promotionModel = new Promotion();
		promotionModel.setEndDate(promotionEntity.getEndDate());
		promotionModel.setPercentage(promotionEntity.getPercentage());
		promotionModel.setPromoId(promotionEntity.getPromoId());
		promotionModel.setStartDate(promotionEntity.getStartDate());
		return promotionModel;
	}
	
	
	public TranslationEntity translationModelToTranslationEntity(Translation translationModel)
	{
		TranslationEntity translationEntity = new TranslationEntity();
		translationEntity.setCategoryTranslation(translationModel.getCategoryTranslation());
		LanguageEntity targetedLanguage = languageModelToLanguageEntity(translationModel.getTargetedLanguage());
		translationEntity.setTargetedLanguage(targetedLanguage);
		CategoryEntity translatedCategory = categoryModelToCategoryEntity(translationModel.getTranslatedCategory());
		translationEntity.setTranslatedCategory(translatedCategory);
		translationEntity.setTranslationId(translationModel.getTranslationId());
		return translationEntity;
	}
	
	
	public Translation translationEntityToTranslationModel(TranslationEntity translationEntity)
	{
		Translation translationModel = new Translation();
		translationModel.setCategoryTranslation(translationEntity.getCategoryTranslation());
		Language targetedLanguage = languageEntityToLanguageModel(translationEntity.getTargetedLanguage());
		translationModel.setTargetedLanguage(targetedLanguage);
		Category translatedCategory = categoryEntityToCategoryModel(translationEntity.getTranslatedCategory());
		translationModel.setTranslatedCategory(translatedCategory);
		translationModel.setTranslationId(translationEntity.getTranslationId());
		return translationModel;
	}
	
	
	public UserEntity userModelToUserEntity(User userModel)
	{
		UserEntity userEntity = new UserEntity();
		userEntity.setBirthDate(userModel.getBirthDate());
		userEntity.setCountry(userModel.getCountry());
		userEntity.setEmail(userModel.getEmail());
		userEntity.setFirstName(userModel.getFirstName());
		userEntity.setLastName(userModel.getLastName());
		userEntity.setNumberOfStreet(userModel.getNumberOfStreet());
		userEntity.setPassword(userModel.getPassword());
		userEntity.setPhoneNumber(userModel.getPhoneNumber());
		userEntity.setPseudo(userModel.getPseudo());
		userEntity.setStreet(userModel.getStreet());
		userEntity.setTown(userModel.getTown());
		userEntity.setUserId(userModel.getUserId());
		userEntity.setZipCode(userModel.getZipCode());
		
		return userEntity;
	}
	
	
	public User userEntityToUserModel(UserEntity userEntity)
	{
		User userModel = new User();
		userModel.setBirthDate(userEntity.getBirthDate());
		userModel.setCountry(userEntity.getCountry());
		userModel.setEmail(userEntity.getEmail());
		userModel.setFirstName(userEntity.getFirstName());
		userModel.setLastName(userEntity.getLastName());
		userModel.setNumberOfStreet(userEntity.getNumberOfStreet());
		userModel.setPassword(userEntity.getPassword());
		userModel.setPhoneNumber(userEntity.getPhoneNumber());
		userModel.setPseudo(userEntity.getPseudo());
		userModel.setStreet(userEntity.getStreet());
		userModel.setTown(userEntity.getTown());
		userModel.setTown(userEntity.getTown());
		userModel.setUserId(userEntity.getUserId());
		userModel.setZipCode(userEntity.getZipCode());
		return userModel;
	}


	public OrderLine orderLineEntityToOrderLineModel(OrderLineEntity orderLineEntity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

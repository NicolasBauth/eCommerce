package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.*;
import com.spring.henallux.model.*;



@Controller
@RequestMapping(value="/single")
public class SingleController {
	

	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ImageDAO imageDAO;
	@Autowired
	private TranslationDAO translationDAO;
	
	private Product singleProduct;
	private ArrayList<Image> images;
	private Translation category;
	
	@RequestMapping(value="/{p}", method=RequestMethod.GET)
	public String home(Model model, @PathVariable("p") String product, Locale locale){
		
		model.addAttribute("bannerMainText", messageSource.getMessage("bannerMainText", null, locale));
		model.addAttribute("bannerSecText", messageSource.getMessage("bannerSecText", null, locale));
		model.addAttribute("bannerCatalogue", messageSource.getMessage("bannerCatalogue", null, locale));
		
		int idLang = Integer.parseInt(messageSource.getMessage("idLang", null, locale));
		
		
		int productId = Integer.parseInt(product);

		singleProduct = productDAO.getProduct(productId);			
		images = imageDAO.findImagesByReferencedProductProductId(singleProduct.getProductId());
		Integer categoryId = singleProduct.getCategory().getCategoryId();
		
		category = translationDAO.findTranslationByTargetedLanguageLanguageIdAndTranslatedCategoryCategoryId(idLang,categoryId);

		model.addAttribute("product", singleProduct);
		model.addAttribute("images", images);
		model.addAttribute("category", category);
		
		return "integrated:single";
	}

	
}


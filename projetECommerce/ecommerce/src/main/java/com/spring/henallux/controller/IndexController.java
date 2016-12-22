package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.*;
import com.spring.henallux.model.*;



@Controller
@RequestMapping(value="/index")
@SessionAttributes({IndexController.PRODUCT})
public class IndexController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ImageDAO imageDAO;
	@Autowired
	private TranslationDAO translationDAO;
	
	protected static final String PRODUCT = "product";
	
	@ModelAttribute(PRODUCT)
	public Product product(){
		return new Product();
	}
	
	private ArrayList<Product> lastProducts;
	private Image imageFromLastProducts;
	private HashMap<Integer, Image> result;
	private ArrayList<Translation> categories;

	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, Locale locale){
		
		model.addAttribute("bannerMainText", messageSource.getMessage("bannerMainText", null, locale));
		model.addAttribute("bannerSecText", messageSource.getMessage("bannerSecText", null, locale));
		model.addAttribute("bannerCatalogue", messageSource.getMessage("bannerCatalogue", null, locale));
		
		int idLang = Integer.parseInt(messageSource.getMessage("idLang", null, locale));
		
		lastProducts = productDAO.findProductByNewArrivals();
		result = new HashMap<Integer, Image>();
		
		for(Product product : lastProducts){
			
			imageFromLastProducts = imageDAO.findImageByReferencedProductProductId(product.getProductId());
			result.put(product.getProductId(), imageFromLastProducts);

		}
		
		categories = translationDAO.findTranslationByTargetedLanguageLanguageId(idLang);

		model.addAttribute("lastProducts", lastProducts);
		model.addAttribute("imageProduct", result);
		model.addAttribute("categories", categories);
		
		return "integrated:index";
	}

	
	
}


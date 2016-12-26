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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.CategoryDAO;
import com.spring.henallux.dataAccess.dao.ProductDAO;
import com.spring.henallux.dataAccess.dao.TranslationDAO;
import com.spring.henallux.model.Category;
import com.spring.henallux.model.Product;
import com.spring.henallux.model.Translation;



@Controller
@RequestMapping(value="/sitemap")
public class SitemapController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private TranslationDAO translationDAO;
	

	
	private ArrayList<Translation> categories;
	private ArrayList<Product> products;
	private HashMap<Integer, ArrayList<Product>> test;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, Locale locale){
		
		model.addAttribute("bannerMainText", messageSource.getMessage("bannerMainText", null, locale));
		model.addAttribute("bannerSecText", messageSource.getMessage("bannerSecText", null, locale));
		model.addAttribute("bannerCatalogue", messageSource.getMessage("bannerCatalogue", null, locale));
		
		model.addAttribute("footerQui", messageSource.getMessage("footerQui", null, locale));
		model.addAttribute("footerQuiText", messageSource.getMessage("footerQuiText", null, locale));
		model.addAttribute("footerAide", messageSource.getMessage("footerAide", null, locale));
		model.addAttribute("footerInfo", messageSource.getMessage("footerInfo", null, locale));
		model.addAttribute("footerContact", messageSource.getMessage("footerContact", null, locale));
		
		model.addAttribute("panier", messageSource.getMessage("panier", null, locale));
		model.addAttribute("connexion", messageSource.getMessage("connexion", null, locale));
		
		model.addAttribute("terms", messageSource.getMessage("terms", null, locale));
		model.addAttribute("privacy", messageSource.getMessage("privacy", null, locale));
		model.addAttribute("sitemap", messageSource.getMessage("sitemap", null, locale));
		model.addAttribute("shipping", messageSource.getMessage("shipping", null, locale));
		
		int idLang = Integer.parseInt(messageSource.getMessage("idLang", null, locale));
		
		categories = translationDAO.findTranslationByTargetedLanguageLanguageId(idLang);
		test = new HashMap<Integer, ArrayList<Product>>();
		
		for(Translation category : categories){
			Integer categoryId = category.getTranslatedCategory().getCategoryId();
			products = productDAO.findProductByCategoryCategoryId(categoryId);
			test.put(categoryId, products);
		}
		
		model.addAttribute("categories", categories);
		model.addAttribute("products", test);
		
		return "integrated:sitemap";
	}

	
	
}

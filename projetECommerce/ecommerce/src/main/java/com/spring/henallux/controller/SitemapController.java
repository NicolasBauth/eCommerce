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
		
		
		categories = translationDAO.findTranslationByTargetedLanguageLanguageId(1);
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

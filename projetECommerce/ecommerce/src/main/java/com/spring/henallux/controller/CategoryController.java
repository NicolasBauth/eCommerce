package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.henallux.dataAccess.dao.*;
import com.spring.henallux.model.*;



@Controller
@RequestMapping(value="/category")
public class CategoryController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ImageDAO imageDAO;
	@Autowired
	private TranslationDAO translationDAO;
	
	private ArrayList<Product> products;
	private Image imageFromLastProducts;
	private HashMap<Integer, Image> result;
	private Translation categoryProducts;
	private ArrayList<Translation> categories;
	
	

	@RequestMapping(value="/{c}", method=RequestMethod.GET)
	public String home(Model model, @PathVariable("c") String category, Locale locale){
		
		model.addAttribute("bannerMainText", messageSource.getMessage("bannerMainText", null, locale));
		model.addAttribute("bannerSecText", messageSource.getMessage("bannerSecText", null, locale));
		model.addAttribute("bannerCatalogue", messageSource.getMessage("bannerCatalogue", null, locale));
		
		int idLang = Integer.parseInt(messageSource.getMessage("idLang", null, locale));
		
		int categoryId = Integer.parseInt(category);

		products = productDAO.findProductByCategoryCategoryId(categoryId);
		result = new HashMap<Integer, Image>();
		
		for(Product product : products){
			
			imageFromLastProducts = imageDAO.findImageByReferencedProductProductId(product.getProductId());
			result.put(product.getProductId(), imageFromLastProducts);

		}
		
		categoryProducts = translationDAO.findTranslationByTargetedLanguageLanguageIdAndTranslatedCategoryCategoryId(idLang, categoryId);
		
		categories = translationDAO.findTranslationByTargetedLanguageLanguageId(idLang);
		
		model.addAttribute("products", products);
		model.addAttribute("image", result);
		model.addAttribute("category", categoryProducts);
		model.addAttribute("categories", categories);
		
		return "integrated:category";
	}

	
	
}


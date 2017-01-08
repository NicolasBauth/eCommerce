package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
@SessionAttributes({SingleController.CURRENTCART, IndexController.NBARTICLESTOTAL})
public class IndexController {
	
	protected static final String CURRENTCART = "currentCart";
	protected static final String NBARTICLESTOTAL = "nbArticlesTotal";
	
	@ModelAttribute(CURRENTCART)
	public HashMap<Integer, Integer> getCurrentCart(){
		return new HashMap<Integer, Integer>();
	}
	@ModelAttribute(NBARTICLESTOTAL)
	public Integer getNbArticlesTotal(){
		return new Integer(0);
	}
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ImageDAO imageDAO;
	@Autowired
	private TranslationDAO translationDAO;
	
	private ArrayList<Product> lastProducts;
	private Image imageFromLastProducts;
	private HashMap<Integer, Image> result;
	private ArrayList<Translation> categories;

	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, Locale locale, @ModelAttribute(value="currentCart") HashMap<Integer, Integer> getCurrentCart){
		
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
		
		model.addAttribute("titreNouv", messageSource.getMessage("titreNouv", null, locale));
		
		model.addAttribute("terms", messageSource.getMessage("terms", null, locale));
		model.addAttribute("privacy", messageSource.getMessage("privacy", null, locale));
		model.addAttribute("sitemap", messageSource.getMessage("sitemap", null, locale));
		model.addAttribute("shipping", messageSource.getMessage("shipping", null, locale));
		
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
		
		int nbArticlesTotal = 0;
		
		for(Map.Entry<Integer, Integer> entry : getCurrentCart.entrySet()) {
			
			nbArticlesTotal += entry.getValue();
		}
		
		model.addAttribute(NBARTICLESTOTAL, nbArticlesTotal);
		
		return "integrated:index";
	}

	
	
}


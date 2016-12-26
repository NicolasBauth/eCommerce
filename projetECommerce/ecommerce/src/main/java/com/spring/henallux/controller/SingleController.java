package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
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
@SessionAttributes({SingleController.CURRENTCART, SingleController.CURRENTTOTAL})
public class SingleController {
	
	protected static final String CURRENTCART = "currentCart";
	protected static final String CURRENTTOTAL = "currentTotal";
	
	//protected static final String NBARTICLESTOTAL = "nbArticlesTotal";
	
	@ModelAttribute(CURRENTCART)
	public HashMap<Integer, Integer> getCurrentCart(){
		return new HashMap<Integer, Integer>();
	}
	
	@ModelAttribute(CURRENTTOTAL)
	public Integer getCurrentTotal(){
		return new Integer(0);
	}
	
	/*@ModelAttribute(NBARTICLESTOTAL)
	public Integer getNbArticlesTotal(){
		return 0;
	}*/
	
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
	public String home(Model model, @PathVariable("p") String product, Locale locale, @ModelAttribute(value=CURRENTTOTAL) Integer currentTotal){
		model.addAttribute("getCurrentCart", new HashMap<Integer, Integer>());
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
		
		model.addAttribute("home", messageSource.getMessage("home", null, locale));
		model.addAttribute("description", messageSource.getMessage("description", null, locale));
		model.addAttribute("qtInd", messageSource.getMessage("qtInd", null, locale));
		model.addAttribute("price", messageSource.getMessage("price", null, locale));
		model.addAttribute("stock", messageSource.getMessage("stock", null, locale));
		model.addAttribute("type", messageSource.getMessage("type", null, locale));

		model.addAttribute("instock", messageSource.getMessage("instock", null, locale));
		model.addAttribute("outstock", messageSource.getMessage("outstock", null, locale));
		model.addAttribute("laststock", messageSource.getMessage("laststock", null, locale));
		
		model.addAttribute("qt", messageSource.getMessage("qt", null, locale));
		model.addAttribute("ajoutPanier", messageSource.getMessage("ajoutPanier", null, locale));
		
		model.addAttribute("terms", messageSource.getMessage("terms", null, locale));
		model.addAttribute("privacy", messageSource.getMessage("privacy", null, locale));
		model.addAttribute("sitemap", messageSource.getMessage("sitemap", null, locale));
		model.addAttribute("shipping", messageSource.getMessage("shipping", null, locale));
		
		int idLang = Integer.parseInt(messageSource.getMessage("idLang", null, locale));
		
		
		int productId = Integer.parseInt(product);

		singleProduct = productDAO.getProduct(productId);			
		images = imageDAO.findImagesByReferencedProductProductId(singleProduct.getProductId());
		Integer categoryId = singleProduct.getCategory().getCategoryId();
		
		category = translationDAO.findTranslationByTargetedLanguageLanguageIdAndTranslatedCategoryCategoryId(idLang,categoryId);

		model.addAttribute("product", singleProduct);
		model.addAttribute("images", images);
		model.addAttribute("category", category);
		
		model.addAttribute("titi2", new AddCartForm());
		
		return "integrated:single";
	}
	
	@RequestMapping(value="/send", method=RequestMethod.POST)
	public String getFormDate(Model model, @ModelAttribute(value="titi2") AddCartForm form, @ModelAttribute(value=CURRENTCART) HashMap<Integer, Integer> currentCart, @ModelAttribute(value=CURRENTTOTAL) Integer currentTotal){
		
		if(currentCart.containsKey(singleProduct.getProductId())){
			int nbArticles = currentCart.get(singleProduct.getProductId());
			currentCart.put(singleProduct.getProductId(), nbArticles+form.getNbArticles());
			
		} else {
			currentCart.put(singleProduct.getProductId(), form.getNbArticles());
			
		}
		
		currentTotal += form.getNbArticles();
		System.out.println("currentTotal " + currentTotal);
		
		/*System.out.println(nbArticlesTotal);
		nbArticlesTotal += form.getNbArticles();
		System.out.println(nbArticlesTotal);*/
	
		return "redirect:/cart";		
		
	}

	
}


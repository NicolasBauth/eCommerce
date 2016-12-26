package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.ImageDAO;
import com.spring.henallux.dataAccess.dao.ProductDAO;
import com.spring.henallux.model.Image;
import com.spring.henallux.model.Product;
import com.spring.henallux.model.User;



@Controller
@RequestMapping(value="/cart")
//@SessionAttributes({"currentUser"})
@SessionAttributes({SingleController.CURRENTCART, CartController.NBARTICLESTOTAL})
public class CartController {

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
	
	private ArrayList<Product> products;
	private Image imageFromLastProducts;
	private HashMap<Integer, Image> result;

	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, Locale locale, String path, @ModelAttribute(value="currentCart") HashMap<Integer, Integer> getCurrentCart, @ModelAttribute(value="nbArticlesTotal") Integer nbArticlesTotal){
		
		//currentCart = new HashMap<Integer, Integer>();
		//model.addAttribute("getCurrentCart", new HashMap<Integer, Integer>());
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
		
		model.addAttribute("emptyCart", messageSource.getMessage("emptyCart", null, locale));
		
		products = new ArrayList<Product>();
		
		/*for (Integer key : currentCart.keySet()) {
			products.add(productDAO.getProduct(key));
		}*/
		
		//int nbArticlesTotal = 0;
		
		for(Map.Entry<Integer, Integer> entry : getCurrentCart.entrySet()) {
			//Integer key = entry.getKey();
			//Integer value = entry.getValue();
			
			//System.out.println("ICI " + entry.getKey());
			//System.out.println("Key " + entry.getKey() + " Value " + entry.getValue());
			nbArticlesTotal += entry.getValue();
			System.out.println(nbArticlesTotal);
			products.add(productDAO.getProduct(entry.getKey()));
		}
		
		/*Iterator entries = currentCart.entrySet().iterator();
		while (entries.hasNext()) {
		  Entry thisEntry = (Entry) entries.next();
		  Integer key = thisEntry.getKey();
		  Object value = thisEntry.getValue();
		  // ...
		}*/
		
		model.addAttribute("products", products);
		
		result = new HashMap<Integer, Image>();
			
		for(Product product : products){
			
			imageFromLastProducts = imageDAO.findImageByReferencedProductProductId(product.getProductId());
			result.put(product.getProductId(), imageFromLastProducts);

		}
		
		model.addAttribute("image", result);
		
		model.addAttribute("nbArticles", nbArticlesTotal);
		System.out.println("TOTAL"+nbArticlesTotal);
		return "integrated:cart";
	}

	
	
}
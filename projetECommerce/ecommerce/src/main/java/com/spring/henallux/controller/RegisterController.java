package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.henallux.dataAccess.dao.ImageDAO;
import com.spring.henallux.dataAccess.dao.ProductDAO;
import com.spring.henallux.dataAccess.dao.TranslationDAO;
import com.spring.henallux.model.Image;
import com.spring.henallux.model.Product;
import com.spring.henallux.model.Translation;

@Controller
@RequestMapping(value="/register")
public class RegisterController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ImageDAO imageDAO;
	@Autowired
	private TranslationDAO translationDAO;

	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, String product, Locale locale){
		
		model.addAttribute("bannerMainText", messageSource.getMessage("bannerMainText", null, locale));
		model.addAttribute("bannerSecText", messageSource.getMessage("bannerSecText", null, locale));
		model.addAttribute("bannerCatalogue", messageSource.getMessage("bannerCatalogue", null, locale));
		
		int idLang = Integer.parseInt(messageSource.getMessage("idLang", null, locale));
		
		return "integrated:register";
	}
}

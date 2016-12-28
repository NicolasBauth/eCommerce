package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.henallux.dataAccess.dao.ImageDAO;
import com.spring.henallux.dataAccess.dao.ProductDAO;
import com.spring.henallux.dataAccess.dao.TranslationDAO;
import com.spring.henallux.dataAccess.dao.UserDAO;
import com.spring.henallux.model.Image;
import com.spring.henallux.model.Product;
import com.spring.henallux.model.RegisterForm;
import com.spring.henallux.model.Translation;
import com.spring.henallux.model.User;

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
	@Autowired
	private UserDAO userDAO;

	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, String product, Locale locale){
		
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
		model.addAttribute("registerForm", new RegisterForm());
		return "integrated:register";
	}
	
	@RequestMapping(value="/sendRegister", method=RequestMethod.POST)
	public String getFormData(Model model, @ModelAttribute(value="registerForm") RegisterForm form)
	{
		if(form.getBirthDate()!="" && form.getCity()!="" && form.getCountry()!="" && form.geteMail()!=""
				&& form.getFirstName()!= "" && form.getLastName()!="" && form.getNumberOfStreet()!=""
				&& form.getPassword()!= "" && form.getPasswordConfirmation()!="" && form.getPhoneNumber()!=""
				&& form.getPseudo()!="" && form.getStreet()!="" && form.getZipCode()!=""
				&& form.getPassword().equals(form.getPasswordConfirmation())
				&& StringUtils.isNumber(form.getNumberOfStreet())
				&& StringUtils.isNumber(form.getPhoneNumber())
				&& StringUtils.isNumber(form.getZipCode()))
		{
			User user = new User();
			user.setLastName(form.getLastName());
			user.setFirstName(form.getFirstName());
			user.setEmail(form.geteMail());
			user.setCountry(form.getCountry());
			user.setNumberOfStreet(Integer.parseInt(form.getNumberOfStreet()));
			user.setPassword(form.getPassword());
			user.setPhoneNumber(form.getPhoneNumber());
			user.setPseudo(form.getPseudo());
			user.setStreet(form.getStreet());
			user.setTown(form.getCity());
			user.setZipCode(Integer.parseInt(form.getZipCode()));
			user.setBirthDate(new Date());
			userDAO.save(user);
			return "redirect:/index";
		}
		else
		{
			return "redirect:/register";
		}
	}
}

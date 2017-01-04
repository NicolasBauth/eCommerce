package com.spring.henallux.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	public String getFormData(Model model, @Valid @ModelAttribute(value="registerForm") RegisterForm form,
								final BindingResult errors)
	{
		
			if(!errors.hasErrors())
			{
				boolean passwordCheck = form.getPassword().equals(form.getPasswordConfirmation());
				boolean userNameCheck = !userDAO.checkWhetherUsernameAlreadyExists(form.getPseudo());
				
				if(!userNameCheck)
				{
					errors.rejectValue("pseudo","error.userNameExists", "Wizard, this username is already used by somebody. Please try another one.");
					return "integrated:register";
				}
				if(!passwordCheck)
				{
					errors.rejectValue("password","error.passwordMismatch", "Wizard, your password and password confirmation don't match.");
					return "integrated:register";
				}
				User user = new User();
				
				user.setBirthDate(form.getBirthDate());	
				user.setLastName(form.getLastName());
				user.setFirstName(form.getFirstName());
				user.setEmail(form.geteMail());
				user.setCountry(form.getCountry());
				user.setNumberOfStreet(form.getNumberOfStreet());
				user.setStreet(form.getStreet());
				user.setTown(form.getCity());
				user.setZipCode(form.getZipCode());
				if(form.getPhoneNumber().equals(""))
				{
					user.setPhoneNumber(null);
				}
				else
				{
					user.setPhoneNumber(form.getPhoneNumber());
				}
				user.setPassword(form.getPassword());
				user.setPseudo(form.getPseudo());
				
				userDAO.save(user);
				return "redirect:/index";
			}
	
		return "integrated:register";
				
	}
	
	
}

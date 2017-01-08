package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.henallux.dataAccess.dao.*;
import com.spring.henallux.model.*;
import com.spring.henallux.service.PasswordEncryptionService;
import com.spring.henallux.service.UserService;



@Controller
@RequestMapping(value="/login")
@SessionAttributes({LoginController.USER})
public class LoginController {
	
	protected static final String USER="currentUser";
	
	@ModelAttribute(USER)
	public User user(){
		return new User();
	}
	
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserService userService;

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
		
		model.addAttribute("newPeople", messageSource.getMessage("newPeople", null, locale));
		model.addAttribute("newPeopleSec", messageSource.getMessage("newPeopleSec", null, locale));
		model.addAttribute("registerNow", messageSource.getMessage("registerNow", null, locale));

		model.addAttribute("loginForm", new LoginForm());
		
		return "integrated:login";
	}

	@RequestMapping(value="/send", method=RequestMethod.POST)
	public String getFormData(Model model, @ModelAttribute(value="loginForm") LoginForm form, @ModelAttribute(value=USER) User currentUser,final BindingResult errors, RedirectAttributes attr){
		if(!errors.hasErrors())
		{
			EncryptedLogin encryptedLogin = userService.encryptLogin(form);
			if(encryptedLogin == null)
			{
				errors.rejectValue("password","password.strangePassword", "The password you entered is strange and couldn't be resolved.");
				attr.addFlashAttribute("org.springframework.validation.BindingResult.loginForm", errors);
			    attr.addFlashAttribute("loginForm",form);
				return "redirect:/login";
			}
			ArrayList<User> users = userDAO.findUserByPseudoAndPassword(encryptedLogin.getUserName(),encryptedLogin.getEncryptedPassword());
			if(users.isEmpty())
			{
				errors.rejectValue("password","password.noMatch", "There wasn't any match for the given username and password.");
				attr.addFlashAttribute("org.springframework.validation.BindingResult.loginForm", errors);
			    attr.addFlashAttribute("loginForm",form);
				return "redirect:/login";
			}
			else {
				model.addAttribute("currentUser", users.get(0));
				return "redirect:/cart";
			}
		}
		attr.addFlashAttribute("org.springframework.validation.BindingResult.loginForm", errors);
	    attr.addFlashAttribute("loginForm",form);
		return "redirect:/login";	
		
	}
	
}
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		
		model.addAttribute("lastNameText",messageSource.getMessage("registerLastNameText",null,locale));
		model.addAttribute("registerText",messageSource.getMessage("registerRegisterText",null,locale));
		model.addAttribute("orderText",messageSource.getMessage("registerOrderText",null,locale));
		model.addAttribute("personalInformationsText",messageSource.getMessage("registerPersonalInformationsText",null,locale));
		model.addAttribute("firstNameText",messageSource.getMessage("registerFirstNameText",null,locale));
		model.addAttribute("birthdateText",messageSource.getMessage("registerBirthdateText",null,locale));
		model.addAttribute("phoneNumberText",messageSource.getMessage("registerPhoneNumberText",null,locale));
		model.addAttribute("deliveryAdressText",messageSource.getMessage("registerDeliveryAdressText",null,locale));
		model.addAttribute("countryText",messageSource.getMessage("registerCountryText",null,locale));
		model.addAttribute("streetText",messageSource.getMessage("registerStreetText",null,locale));
		model.addAttribute("numberText",messageSource.getMessage("registerNumberText",null,locale));
		model.addAttribute("zipCodeText",messageSource.getMessage("registerZipCodeText",null,locale));
		model.addAttribute("cityText",messageSource.getMessage("registerCityText",null,locale));
		model.addAttribute("idText",messageSource.getMessage("registerIdText",null,locale));
		model.addAttribute("emailText",messageSource.getMessage("registerEmailText",null,locale));
		model.addAttribute("userNameText",messageSource.getMessage("registerUserNameText",null,locale));
		model.addAttribute("passwordText",messageSource.getMessage("registerPasswordText",null,locale));
		model.addAttribute("confirmPasswordText",messageSource.getMessage("registerConfirmPasswordText",null,locale));
		model.addAttribute("createText",messageSource.getMessage("registerCreateText",null,locale));
		
		int idLang = Integer.parseInt(messageSource.getMessage("idLang", null, locale));
		if (!model.containsAttribute("registerForm"))
		{
			model.addAttribute("registerForm", new RegisterForm());
		}
		return "integrated:register";
	}
	
	@RequestMapping(value="/sendRegister", method=RequestMethod.POST)
	public String getFormData(Model model, @Valid @ModelAttribute(value="registerForm") RegisterForm register,
								final BindingResult errors, RedirectAttributes attr)
	{
		
			if(!errors.hasErrors())
			{
				boolean passwordCheck = register.getPassword().equals(register.getPasswordConfirmation());
				boolean userNameCheck = !userDAO.checkWhetherUsernameAlreadyExists(register.getPseudo());
				
				if(!userNameCheck)
				{
					errors.rejectValue("pseudo","pseudo.alreadyExists", "Wizard, this username or password is already used by somebody. Please try another one.");
					attr.addFlashAttribute("org.springframework.validation.BindingResult.registerForm", errors);
				    attr.addFlashAttribute("registerForm",register );
					return "redirect:/register";
				}
				if(!passwordCheck)
				{
					errors.rejectValue("password","password.mismatch", "Wizard, your password and password confirmation don't match.");
					attr.addFlashAttribute("org.springframework.validation.BindingResult.registerForm", errors);
				    attr.addFlashAttribute("registerForm",register );
					return "redirect:/register";
				}
				User user = new User();
				
				user.setBirthDate(register.getBirthDate());	
				user.setLastName(register.getLastName());
				user.setFirstName(register.getFirstName());
				user.setEmail(register.geteMail());
				user.setCountry(register.getCountry());
				user.setNumberOfStreet(register.getNumberOfStreet());
				user.setStreet(register.getStreet());
				user.setTown(register.getCity());
				user.setZipCode(register.getZipCode());
				if(register.getPhoneNumber().equals(""))
				{
					user.setPhoneNumber(null);
				}
				else
				{
					user.setPhoneNumber(register.getPhoneNumber());
				}
				user.setPassword(register.getPassword());
				user.setPseudo(register.getPseudo());
				
				userDAO.save(user);
				return "redirect:/index";
			}
			attr.addFlashAttribute("org.springframework.validation.BindingResult.registerForm", errors);
		    attr.addFlashAttribute("registerForm",register );
	
		return "redirect:/register";
				
	}
	
	
}

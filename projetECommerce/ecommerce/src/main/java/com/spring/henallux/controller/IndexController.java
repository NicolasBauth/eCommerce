package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.List;
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

import com.spring.henallux.dataAccess.dao.ProductDAO;
import com.spring.henallux.model.Category;
import com.spring.henallux.model.Product;



@Controller
@RequestMapping(value="/index")
@SessionAttributes({IndexController.PRODUCT})
public class IndexController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ProductDAO productDAO;
	
	//protected static final String CATEGORY = "mainCat";
	protected static final String PRODUCT = "product";
	
	/*@ModelAttribute(CATEGORY)
	public Category truc(){
		return new Category();
	}
	*/
	@ModelAttribute(PRODUCT)
	public Product product(){
		return new Product();
	}
	
	//@Autowired
	//private ArrayList<Product> lastProducts;

	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, Locale locale){
		//productDAO = new ProductDAO();
		//lastProducts = productDAO.getAllProducts();
		
		System.out.println(productDAO.getAllProducts());
		System.out.println(" ICICIOECNE?klCLKNA ");
		for (Product v : productDAO.getAllProducts())
		      System.out.print(v.getName() + " HAHA ");
		System.out.println();
		
		model.addAttribute("bannerMainText", messageSource.getMessage("bannerMainText", null, locale));
		model.addAttribute("bannerSecText", messageSource.getMessage("bannerSecText", null, locale));
		model.addAttribute("lastProducts", productDAO.getAllProducts());
		return "integrated:index";
	}

	
	
}


package com.spring.henallux.controller;

import java.util.logging.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value="/categorie")
public class CategorieController {

	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model){
		return "integrated:categorie";
	}

	
	
}


package com.spring.henallux.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.CategoryDAO;
import com.spring.henallux.dataAccess.dao.ImageDAO;
import com.spring.henallux.dataAccess.dao.OrderDAO;
import com.spring.henallux.dataAccess.dao.ProductDAO;
import com.spring.henallux.model.Image;
import com.spring.henallux.model.Order;
import com.spring.henallux.model.OrderLine;
import com.spring.henallux.model.Product;
import com.spring.henallux.model.Promotion;
import com.spring.henallux.model.User;

@Controller
@RequestMapping(value="/order")
@SessionAttributes({"currentUser", OrderController.CURRENTCART, OrderController.NBARTICLESTOTAL})
public class OrderController {
	protected static final String CURRENTCART = "currentCart";
	protected static final String NBARTICLESTOTAL = "nbArticlesTotal";
	
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ImageDAO imageDAO;
	@Autowired
	private MessageSource messageSource;
	
	@ModelAttribute("currentUser")
	public User user()
	{
		return new User();
	}
	
	private HashMap<Integer, Image> result;
	private Image imageFromLastProducts;

	
	@RequestMapping(method=RequestMethod.GET)
	public String listeCommandes(Model model, @ModelAttribute("currentUser")User user, Locale locale){
		if(user.getPseudo() == null){
			return "redirect:/login";
		}
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

		ArrayList<Order> lc = orderDAO.getOrdersByUser(user);
				
		
		model.addAttribute("currentOrders", lc);
		return "integrated:orders";
	}
	@RequestMapping(method=RequestMethod.GET, value="/{idOrder}")
	public String detailOrder(Model model, @ModelAttribute("currentUser")User user, @PathVariable Integer idOrder, Locale locale){
		if(user.getPseudo() == null){
			return "redirect:/login";
		}
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
		
		Order comm = orderDAO.getOrderById(idOrder);
		
		result = new HashMap<Integer, Image>();
		
		BigDecimal prixTotal = new BigDecimal(0);
					
		for(OrderLine line : comm.getOrderLines()) {
			imageFromLastProducts = imageDAO.findImageByReferencedProductProductId(line.getOrderedProduct().getProductId());
			result.put(line.getOrderedProduct().getProductId(), imageFromLastProducts);
			BigDecimal qte = new BigDecimal(line.getQuantity());
			prixTotal = prixTotal.add(qte.multiply(line.getUnitPrice()));
		}

		model.addAttribute("prixTotal", prixTotal);
		model.addAttribute("image", result);
		
		if(comm.getCustomer().getUserId() != user.getUserId())
			return "redirect:/welcome";
		
		model.addAttribute("order", comm);
		
		return "integrated:detailsOrder";
	}

	@RequestMapping(method=RequestMethod.GET, value="/order")
	public String passerCommande(Model model, @ModelAttribute(value="currentCart")HashMap<Integer,Integer> cart, @ModelAttribute(value="currentUser")User user, Locale locale){
		if(user.getPseudo() == null){
			return "redirect:/login/";
		}
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
		
		Order commande = new Order(user);
		List<OrderLine> lignes = new ArrayList<OrderLine>();
		BigDecimal prixTotal = new BigDecimal(0);
		for(Entry<Integer, Integer> entry : cart.entrySet()){
			Product article = productDAO.getProduct(entry.getKey());

			BigDecimal prix = article.getUnitPrice();
			prixTotal = prixTotal.add(prix.multiply(new BigDecimal(entry.getValue())));

			OrderLine ligne = new OrderLine(commande, article, prix, entry.getValue());
			lignes.add(ligne);
		}
		
		commande = orderDAO.addOrder(commande, lignes);
		model.addAttribute(CURRENTCART, new HashMap<Integer, Integer>());
		model.addAttribute(NBARTICLESTOTAL, 0);
		
		return "redirect:/order/" + commande.getOrderId().toString();

	}
}
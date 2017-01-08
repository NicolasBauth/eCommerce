package com.spring.henallux.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.CategoryDAO;
import com.spring.henallux.dataAccess.dao.OrderDAO;
import com.spring.henallux.dataAccess.dao.ProductDAO;
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
	
	@ModelAttribute("currentUser")
	public User user()
	{
		return new User();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String listeCommandes(Model model, @ModelAttribute("currentUser")User user, Locale locale){
		if(user.getPseudo() == null){
			return "redirect:/login";
		}

		ArrayList<Order> lc = orderDAO.getOrdersByUser(user);
		model.addAttribute("currentOrders", lc);
		return "integrated:orders";
	}
	@RequestMapping(method=RequestMethod.GET, value="/{idOrder}")
	public String detailOrder(Model model, @ModelAttribute("currentUser")User user, @PathVariable Integer idOrder, Locale locale){
		if(user.getPseudo() == null){
			return "redirect:/login";
		}
		
		Order comm = orderDAO.getOrderById(idOrder);
		
		if(comm.getCustomer().getUserId() != user.getUserId())
			return "redirect:/welcome";
		
		model.addAttribute("order", comm);
		
		return "integrated:detailsOrder";
	}

	@RequestMapping(method=RequestMethod.GET, value="/order")
	public String passerCommande(Model model, @ModelAttribute(value="currentCart")HashMap<Integer,Integer> cart, @ModelAttribute(value="currentUser")User user){
		if(user.getPseudo() == null){
			return "redirect:/login/";
		}
		Order commande = new Order(user);
		List<OrderLine> lignes = new ArrayList<OrderLine>();
		BigDecimal prixTotal = new BigDecimal(0);
		for(Entry<Integer, Integer> entry : cart.entrySet()){
			Product article = productDAO.getProduct(entry.getKey());

			BigDecimal prix = getPriceWithReduction(article);
			prixTotal.add(prix.multiply(new BigDecimal(entry.getValue())));

			OrderLine ligne = new OrderLine(commande, article, prix, entry.getValue());
			lignes.add(ligne);
		}
		
		commande = orderDAO.addOrder(commande, lignes);
		model.addAttribute(CURRENTCART, new HashMap<Integer, Integer>());
		model.addAttribute(NBARTICLESTOTAL, 0);
		
		return "redirect:/order/" + commande.getOrderId().toString();

	}
	private BigDecimal getPriceWithReduction(Product art){
		BigDecimal prix = art.getUnitPrice();

		//Application d'un éventuelle promo
		if(art.getPromotion() != null){
			Promotion promo = art.getPromotion();
			Date now = new Date();
			if(promo.getStartDate() == null || promo.getStartDate().before(now)){
				if(promo.getEndDate() == null || promo.getEndDate().after(now)){
					BigDecimal cent = new BigDecimal(100);
					BigDecimal one = new BigDecimal(1);
					prix.multiply(one.subtract(art.getPromotion().getPercentage().divide(cent)));
				}
			}
		}
		return prix;
	}
}
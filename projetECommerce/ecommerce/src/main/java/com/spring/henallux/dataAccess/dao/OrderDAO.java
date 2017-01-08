package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.OrderLineEntity;
import com.spring.henallux.dataAccess.entity.OrderEntity;
import com.spring.henallux.dataAccess.repository.OrderLineRepository;
import com.spring.henallux.dataAccess.repository.OrderRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.OrderLine;
import com.spring.henallux.model.Order;
import com.spring.henallux.model.User;

@Service
@Transactional
public class OrderDAO 
{
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderLineRepository orderLineRepository;
	@Autowired
	private ProviderConverter providerConverter;
	
	public Order save(Order order)
	{
		OrderEntity orderEntity = providerConverter.orderModelToOrderEntity(order);
		orderEntity = orderRepository.save(orderEntity);
		return providerConverter.orderEntityToOrderModel(orderEntity);
	}
	
	public ArrayList<Order> getAllOrders()
	{
		List<OrderEntity> orderEntities = orderRepository.findAll();
		ArrayList<Order> orders = new ArrayList<Order>();
		for (OrderEntity orderEntity : orderEntities)
		{
			Order order = providerConverter.orderEntityToOrderModel(orderEntity);
			orders.add(order);
		}
		return orders;
	}
	public Order getOrderById(int id){
		return providerConverter.orderEntityToOrderModel(orderRepository.getOne(id));
	}
	public ArrayList<Order> getOrdersByUser(User user){
		List<OrderEntity> entities = orderRepository.findByCustomerUserId(user.getUserId());
		ArrayList<Order> orders = new ArrayList<Order>();
		for (OrderEntity orderEntity : entities)
		{
			Order order = providerConverter.orderEntityToOrderModel(orderEntity);
			orders.add(order);
		}
		return orders;
	}
	
	public Order addOrder(Order commande, List<OrderLine> lignes){
		OrderEntity comEntity = providerConverter.orderModelToOrderEntity(commande);

		comEntity = orderRepository.saveAndFlush(comEntity);
		
		List<OrderLineEntity> lignesEntity = new ArrayList<OrderLineEntity>();
		for(OrderLine ligne : lignes){
			OrderLineEntity liEntity = providerConverter.orderLineModelToOrderLineEntity(ligne);
			liEntity.setOrder(comEntity);
			lignesEntity.add(liEntity);
		}
		
		orderLineRepository.save(lignesEntity);
		orderLineRepository.flush();
		
		return providerConverter.orderEntityToOrderModel(comEntity);
	}
	
}

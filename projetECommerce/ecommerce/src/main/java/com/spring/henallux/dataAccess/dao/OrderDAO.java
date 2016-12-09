package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.OrderEntity;
import com.spring.henallux.dataAccess.repository.OrderRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Order;

@Service
@Transactional
public class OrderDAO 
{
	@Autowired
	private OrderRepository orderRepository;
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
	
}

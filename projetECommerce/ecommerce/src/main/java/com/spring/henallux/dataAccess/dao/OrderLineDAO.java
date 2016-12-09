package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.OrderLineEntity;
import com.spring.henallux.dataAccess.repository.OrderLineRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.OrderLine;

@Service
@Transactional
public class OrderLineDAO 
{
	@Autowired
	private OrderLineRepository orderLineRepository;
	@Autowired
	private ProviderConverter providerConverter;
	public OrderLine save(OrderLine orderLine)
	{
		OrderLineEntity orderLineEntity = providerConverter.orderLineModelToOrderLineEntity(orderLine);
		orderLineEntity = orderLineRepository.save(orderLineEntity);
		return providerConverter.orderLineEntityToOrderLineModel(orderLineEntity);
	}
	
	public ArrayList<OrderLine> getAllOrderLines()
	{
		List<OrderLineEntity> orderLineEntities = orderLineRepository.findAll();
		ArrayList<OrderLine> orderLines = new ArrayList<OrderLine>();
		for(OrderLineEntity orderLineEntity : orderLineEntities)
		{
			OrderLine orderLine = providerConverter.orderLineEntityToOrderLineModel(orderLineEntity);
			orderLines.add(orderLine);
		}
		return orderLines;
	}
}

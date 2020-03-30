package com.ey.trp.ordermanagement.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.trp.ordermanagement.model.OrderMgmt;
import com.ey.trp.ordermanagement.repository.OrderRepository;

import java.util.List;
@Service
public class OrderService {
	@Autowired
	OrderRepository repository;

	
	public OrderMgmt Save(OrderMgmt order) {
		OrderMgmt savedOrder=repository.save(order);
		return savedOrder;
	}
	
	public Optional<OrderMgmt> findOne(Integer id) {
		Optional<OrderMgmt> savedOrder=repository.findById(id);
		return savedOrder;
	}

	public List<OrderMgmt> retreiveAllOrders() {
		return repository.findAll();
	}
	

}

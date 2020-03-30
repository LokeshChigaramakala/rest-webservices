package com.ey.trp.ordermanagement.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ey.trp.ordermanagement.exception.OrderNotFoundException;
import com.ey.trp.ordermanagement.model.OrderMgmt;
import com.ey.trp.ordermanagement.service.OrderService;
@RestController
public class OrderController {
	@Autowired
	OrderService service;
	
	@PostMapping(path= "/orders", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> createOrder(@RequestBody OrderMgmt order) {
		System.out.println("orderId::"+order.getOrderSize());
		OrderMgmt saveOrder=service.Save(order);
		//return SaveOrder;
		System.out.println("Order saved successfully"+saveOrder.getSecurityIdentifier());
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(saveOrder.getSecurityIdentifier()).toUri();
				return ResponseEntity.created(location).build();
		
	}
	@GetMapping(path="/orders/{id}")
	public Optional<OrderMgmt> retreiveOrder(@PathVariable Integer id) {
		System.out.println("inside orders controller"+id);
		Optional<OrderMgmt> order= service.findOne(id);
		if(!order.isPresent()) {
			throw new OrderNotFoundException("id"+id);
		}
		
		return order;
	}
	
	@GetMapping(path="/allorders")
	public List<OrderMgmt> retreiveAllOrders() {
		return service.retreiveAllOrders();
		
		
	}
	

}

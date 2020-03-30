package com.ey.trp.ordermanagement.test.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ey.trp.ordermanagement.model.OrderMgmt;
import com.ey.trp.ordermanagement.repository.OrderRepository;
import com.ey.trp.ordermanagement.service.OrderService;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
	@InjectMocks
	OrderService service;
	@Mock
	private OrderRepository repository;
	@Test
	public void testfindOne() {

		 Optional<OrderMgmt> opt=Optional.of(new OrderMgmt(1, "27", "day Order", "broker", "market"));
		assertNotNull(when(repository.findById(1)).thenReturn(opt));
		
	}
	@Test
	public void retreiveAllOrders() {
		 List<OrderMgmt> strList=new ArrayList<OrderMgmt>();
		 strList.add(new OrderMgmt(1, "27", "day Order", "broker", "market"));
		 strList.add(new OrderMgmt(1, "27", "day Order", "broker", "market"));
		 assertNotNull( when(repository.findAll()).thenReturn(strList));
		
	}
}

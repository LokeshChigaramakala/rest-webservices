package com.ey.trp.ordermanagement.test.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.MediaType;

import org.assertj.core.util.Arrays;
import org.json.JSONException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ey.trp.ordermanagement.controller.OrderController;
import com.ey.trp.ordermanagement.model.OrderMgmt;
import com.ey.trp.ordermanagement.service.OrderService;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	OrderService service;
	
	String actResponse="{\r\n" + 
			"securityIdentifier: 1,\r\n" + 
			"orderSize: \"27\",\r\n" + 
			"orderInstructions: \"day Order\",\r\n" + 
			"orderTransmission: \"broker\",\r\n" + 
			"orderType: \"market\"\r\n" + 
			"}";
	 @Test
	 public void testretreiveOrder() throws Exception {
		 
		 Optional<OrderMgmt> opt=Optional.of(new OrderMgmt(1, "27", "day Order", "broker", "market"));
		 
		 when(service.findOne(1)).thenReturn(opt);
		 RequestBuilder request=MockMvcRequestBuilders.get("/orders/1").accept(MediaType.APPLICATION_JSON);
			MvcResult result=mockMvc.perform(request)
					.andExpect(status().isOk())		
					.andReturn();
		}
	 @Test
	 @Ignore
	 public void testretreiveOrder1() throws Exception {
		 
		 Optional<OrderMgmt> opt=Optional.of(new OrderMgmt(1, "27", "day Order", "broker", "market"));
		 
		 when(service.findOne(1)).thenReturn(opt);
		 RequestBuilder request=MockMvcRequestBuilders.get("/orders/1").accept(MediaType.APPLICATION_JSON);
			MvcResult result=mockMvc.perform(request)
					.andExpect(status().isOk())
					.andExpect(content().json("{\r\n" + 
							"securityIdentifier: 1,\r\n" + 
							"orderSize: \"27\",\r\n" + 
							"orderInstructions: \"day Order\",\r\n" + 
							"orderTransmission: \"broker\",\r\n" + 
							"orderType: \"market\"\r\n" + 
							"}"))
					.andReturn();
		}
	
	@Test
	 public void jsonAssert() throws JSONException{
		 String expectedResponse="{\r\n" + 
					"securityIdentifier: 1,\r\n" + 
					"orderSize: \"27\",\r\n" + 
					"orderInstructions: \"day Order\",\r\n" + 
					"orderTransmission: \"broker\",\r\n" + 
					"orderType: \"market\"\r\n" + 
					"}";
		 JSONAssert.assertEquals(expectedResponse,actResponse,true);
	 }
	    
	 @Test
	 public void testretreiveAllOrder() throws Exception {
		 
		
		 List<OrderMgmt> strList=new ArrayList<OrderMgmt>();
		 strList.add(new OrderMgmt(1, "27", "day Order", "broker", "market"));
		 strList.add(new OrderMgmt(1, "27", "day Order", "broker", "market"));
		 
				 
			
		/*List<Object> mgList= Arrays.asList(new OrderMgmt(1, "27", "day Order", "broker", "market"),
				new OrderMgmt(1, "27", "day Order", "broker", "market"));
		 */
		 when(service.retreiveAllOrders()).thenReturn(strList);
		 RequestBuilder request=MockMvcRequestBuilders.get("/allorders").accept(MediaType.APPLICATION_JSON);
			MvcResult result=mockMvc.perform(request)
					.andExpect(status().isOk())		
					.andReturn();
		}

}

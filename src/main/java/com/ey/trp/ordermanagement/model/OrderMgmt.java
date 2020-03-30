package com.ey.trp.ordermanagement.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
//@Table(name="order_table")
public class OrderMgmt {
	@Id
	@GeneratedValue
	@Column(name="security_identifier")
	private Integer SecurityIdentifier;
	@NotBlank(message = "Order type is mandatory")
    @Column(name="order_type")
	private String OrderType;
	@Size(min=2,message="OrderSize should be  greater than 10 ")
	@Column(name="order_size")
	private String OrderSize;
	@Column(name="order_instructions")
	private  String OrderInstructions;
	@NotBlank(message="order_transmiss")
	@Column(name="order_transmission")
	private String  OrderTransmission;
	public OrderMgmt() {
		
	}
	public OrderMgmt(Integer securityIdentifier, String orderType, String orderSize, String orderInstructions,
			String orderTransmission) {
		super();
		SecurityIdentifier = securityIdentifier;
		OrderType = orderType;
		OrderSize = orderSize;
		OrderInstructions = orderInstructions;
		OrderTransmission = orderTransmission;
	}
	public Integer getSecurityIdentifier() {
		return SecurityIdentifier;
	}
	public void setSecurityIdentifier(Integer securityIdentifier) {
		SecurityIdentifier = securityIdentifier;
	}
	public String getOrderType() {
		return OrderType;
	}
	public void setOrderType(String orderType) {
		OrderType = orderType;
	}
	public String getOrderSize() {
		return OrderSize;
	}
	public void setOrderSize(String orderSize) {
		OrderSize = orderSize;
	}
	public String getOrderInstructions() {
		return OrderInstructions;
	}
	public void setOrderInstructions(String orderInstructions) {
		OrderInstructions = orderInstructions;
	}
	public String getOrderTransmission() {
		return OrderTransmission;
	}
	public void setOrderTransmission(String orderTransmission) {
		OrderTransmission = orderTransmission;
	}

}

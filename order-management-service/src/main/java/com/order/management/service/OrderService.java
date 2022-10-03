package com.order.management.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.management.bl.impl.OrderAccessImpl;
import com.order.management.bl.impl.OrderManagerImpl;

@RestController
public class OrderService {
	@PostMapping("/organization/{org_id}/order")
	public String saveOrder(@PathVariable int org_id, @RequestBody String orderString) {
		return OrderManagerImpl.getInstance().saveOrder(org_id, orderString);
	}
	
	@GetMapping("/organization/{org_id}/orders")
	public String getOrder(@PathVariable int org_id) {
		return OrderAccessImpl.getInstance().getOrders(org_id);
	}
	
	@GetMapping("/organization/getOrdersByCustomerId")
	public String getOrdersByCustomerId(int org_id, int customer_id) {
		return OrderAccessImpl.getInstance().getOrdersByCustomerId(org_id, customer_id);
	}
}

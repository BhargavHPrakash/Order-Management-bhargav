package com.order.management.bl.impl;

import java.util.List;

import com.google.gson.Gson;
import com.order.management.bl.OrderAccess;
import com.order.management.dao.impl.OrderAccessDaoImpl;
import com.order.management.model.Order;

public class OrderAccessImpl implements OrderAccess {
	private static OrderAccessImpl orderAccessImpl = null;
	
	private OrderAccessImpl() {
		
	}
	
	public static OrderAccessImpl getInstance() {
		if (orderAccessImpl == null) {
			return orderAccessImpl = new OrderAccessImpl();
		}
		return orderAccessImpl;
	}
	
	@Override
	public String getOrders(int id) {
		List<com.order.dto.Order> order =  OrderAccessDaoImpl.getInstance().getOrders();
		Order orderEntity = new Order();
		orderEntity.setOrgId(id);
		String jsonInString = new Gson().toJson(order);
		return jsonInString;
	}

	@Override
	public String getOrdersByCustomerId(int org_id, int customer_id) {
		List<com.order.dto.Order> order =  OrderAccessDaoImpl.getInstance().getOrdersByCustomerId();
		Order orderEntity = new Order();
		orderEntity.setOrgId(org_id);
		orderEntity.setCustomerId(customer_id);
		String jsonInString = new Gson().toJson(order);
		return jsonInString;
	}
}

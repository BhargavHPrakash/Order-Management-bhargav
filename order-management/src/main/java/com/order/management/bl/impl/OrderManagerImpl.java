package com.order.management.bl.impl;

import com.google.gson.Gson;
import com.order.dto.Order;
import com.order.management.bl.OrderManager;
import com.order.management.dao.impl.OrderManagerDaoImpl;

public class OrderManagerImpl implements OrderManager {

	private static OrderManagerImpl orderManagerImpl = null;

	private OrderManagerImpl() {

	}

	public static OrderManagerImpl getInstance() {
		if (orderManagerImpl == null) {
			return orderManagerImpl = new OrderManagerImpl();
		}
		return orderManagerImpl;
	}

	@Override
	public String saveOrder(int id, String pOrderString) {
		Order order = new Gson().fromJson(pOrderString, Order.class);
		order.setOrgId(id);
		boolean daoCondidtion = OrderManagerDaoImpl.getInstance().saveOrder(order);
		if (daoCondidtion) {
			return "saved";
		} else {
			return "not saved";
		}
	}
}

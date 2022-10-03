package com.order.management.dao;

import java.util.List;

import com.order.dto.Order;

public interface OrderAccessDao {
	List<Order> getOrders();
	List<Order> getOrdersByCustomerId();
}

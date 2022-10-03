package com.order.management.dao;

import com.order.dto.Order;

public interface OrderManagerDao {
	boolean saveOrder(Order order);
}

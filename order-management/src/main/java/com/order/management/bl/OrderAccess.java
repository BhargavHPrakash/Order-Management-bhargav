package com.order.management.bl;

public interface OrderAccess {
	String getOrders(int id);
	String getOrdersByCustomerId(int org_id, int customer_id);
}

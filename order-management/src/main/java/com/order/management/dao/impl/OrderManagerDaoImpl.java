package com.order.management.dao.impl;

import org.hibernate.Session;

import com.order.dto.Order;
import com.order.management.dao.OrderManagerDao;
import com.properties.management.util.HibernateUtil;

public class OrderManagerDaoImpl implements OrderManagerDao{
	private static OrderManagerDaoImpl daoImpl = null;

	private OrderManagerDaoImpl() {
		
	}

	public static OrderManagerDaoImpl getInstance() {
		if (daoImpl == null) {
			return daoImpl = new OrderManagerDaoImpl();
		}
		return daoImpl;
	}
	
	@Override
	public boolean saveOrder(Order order) {
		org.hibernate.Transaction transaction = null;
		Session session = null;
		
		try {
			HibernateUtil.getInstance();
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			com.order.management.model.Order orderManagement = new com.order.management.model.Order();
			
			orderManagement.setOrgId(order.getOrgId());
			orderManagement.setCustomerId(order.getCustomerId());
			orderManagement.setItemId(order.getItemId());
			orderManagement.setPrice(order.getPrice());
			orderManagement.setQuantity(order.getQuantity());
			
			session.save(orderManagement);
			transaction.commit();
			return true;
		}
		catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
		finally {
			session.close();
		}
	}
}

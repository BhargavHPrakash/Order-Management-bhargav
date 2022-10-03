package com.order.management.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.order.dto.Order;
import com.order.management.dao.OrderAccessDao;
import com.properties.management.util.HibernateUtil;

public class OrderAccessDaoImpl implements OrderAccessDao {
	private static OrderAccessDaoImpl orderAccessDaoImpl = null;
	
	private OrderAccessDaoImpl() {
		
	}
	
	public static OrderAccessDaoImpl getInstance() {
		if (orderAccessDaoImpl == null) {
			return orderAccessDaoImpl = new OrderAccessDaoImpl();
		}
		return orderAccessDaoImpl;
	}
	
	@Override
	public List<Order> getOrders() {
		Session session = HibernateUtil.getSessionFactory().openSession();
//		Criteria cr = session.createCriteria(com.order.management.model.Order.class);
//		List<Order> list = cr.list();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<com.order.management.model.Order> query = builder.createQuery(com.order.management.model.Order.class);
		Root<com.order.management.model.Order> root = query.from(com.order.management.model.Order.class);
		query.select(root);
		Query q = session.createQuery(query);
		List<Order> list = q.getResultList();
		
		return list;
	}
	
	@Override
	public List<Order> getOrdersByCustomerId() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = session.createCriteria(com.order.management.model.Order.class);
		cr.add(Restrictions.eq("customerId", 3));
		List<Order> list = cr.list();
		
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery criteriaQuery = builder.createQuery();
//		Root orderModel = criteriaQuery.from(com.order.management.model.Order.class);
//		criteriaQuery.where(builder.equal(orderModel.get("customerId"), builder.parameter(Long.class, "customerId")));
//		Query query = session.createQuery(criteriaQuery);
//		query.setParameter("customerId", 3);
//		List<Order> list = (List<Order>) query.getSingleResult();
		
		return list;
	}
}

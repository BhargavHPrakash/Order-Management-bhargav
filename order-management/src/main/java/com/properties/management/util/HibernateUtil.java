package com.properties.management.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
private static final SessionFactory sessionFactory;

	private static HibernateUtil hibernateUtil = null;
	
	private static Properties dbProperties = new Properties();
	
	private HibernateUtil() {
		
	}
	
	public static HibernateUtil getInstance() {
		if (hibernateUtil == null) {
			return hibernateUtil = new HibernateUtil();
		}
		return hibernateUtil;
	}
	
	static {
		try {
			PropertiesUtil.getPropertiesUtil();
			dbProperties = PropertiesUtil.loadProperties("sqldb");
			Configuration configuration = new Configuration();
			configuration.setProperties(dbProperties);
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
		} catch (Throwable ex) {
			ex.printStackTrace();
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

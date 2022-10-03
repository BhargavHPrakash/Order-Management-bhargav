package com.properties.management.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	static Properties properties = new Properties();

	private static PropertiesUtil propertiesUtil = null;
	
	private PropertiesUtil() {
		
	}
	
	public static PropertiesUtil getPropertiesUtil() {
		if (propertiesUtil == null) {
			return propertiesUtil = new PropertiesUtil();
		}
		return propertiesUtil;
	}
	
	public static Properties loadProperties(String name) {
		try {
			InputStream inputStream = new FileInputStream(System.getenv("sqldb") +"\\"+name+".properties");
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}

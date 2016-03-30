package com.sains.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * Use for loading the application properties
 * 
 * @author Admin
 *
 */
public final class AppProperties {
	public static final String APP_PROPERTIES_FILE = "application.properties";	
	private static final String PRODUCT_LIST_URL = "sains.products.list.url";	 
	private static Properties properties = new Properties();
	
	@SuppressWarnings("unused")
	private static AppProperties instance = new AppProperties();
	
	/**
	 * Singleton. Load the application.properties
	 */
	private AppProperties() {
		try (InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(APP_PROPERTIES_FILE);)
		{
			properties.load(is);
			
		} catch (IOException e){
			throw new RuntimeException(e);
		} 
	}
	
	/**
	 * 
	 * @return the product list url
	 */
	public static String getProductListUrl() {
		return properties.getProperty(PRODUCT_LIST_URL);
	}
}

package com.sains.app;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Unit test for simple App.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({ URL.class, HttpURLConnection.class, App.class })
public class AppTest extends BaseTestCase {
	
	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() throws Exception {
//		URL u = PowerMockito.mock(URL.class);
//        String url = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";
//        PowerMockito.whenNew(URL.class).withArguments(url).thenReturn(u);
//        HttpURLConnection huc = PowerMockito.mock(HttpURLConnection.class);
//        PowerMockito.when(u.openConnection()).thenReturn(huc);
//        
//        String fileContent = readFile("productList1.html", StandardCharsets.UTF_8);        
//        InputStream stream = new ByteArrayInputStream(fileContent.getBytes(StandardCharsets.UTF_8));
//                
//        PowerMockito.when(huc.getInputStream()).thenReturn(stream);
//		
//		App.main(null);		
	}
}

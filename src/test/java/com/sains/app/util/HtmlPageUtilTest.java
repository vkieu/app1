package com.sains.app.util;

import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.sains.app.BaseTestCase;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ URL.class, HttpURLConnection.class, HtmlPageUtil.class})
public class HtmlPageUtilTest extends BaseTestCase {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testFetchContent() {		
		try {			
	        URL u = PowerMockito.mock(URL.class);
	        String url = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";
	        PowerMockito.whenNew(URL.class).withArguments(url).thenReturn(u);
	        HttpURLConnection huc = PowerMockito.mock(HttpURLConnection.class);
	        PowerMockito.when(u.openConnection()).thenReturn(huc);
	        
	        String fileContent = readFile("productList1.html", StandardCharsets.UTF_8);        
	        InputStream stream = new ByteArrayInputStream(fileContent.getBytes(StandardCharsets.UTF_8));	                
	        PowerMockito.when(huc.getInputStream()).thenReturn(stream);
	        
	        String output = HtmlPageUtil.fetchUrlContent(url);

	        assertNotNull(output);
	        assertEquals(fileContent, output);
	      
		
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}

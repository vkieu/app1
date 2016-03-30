package com.sains.app.screen;

import java.nio.charset.Charset;

import org.junit.Test;

import com.sains.app.BaseTestCase;

public class ProductHtmlPageTest extends BaseTestCase {
	
	@Test
	public void testScrapes_notNull() {
		ProductHtmlPage page = new ProductHtmlPage();
		try {										
			page.scrapes(null);			
			fail("Exception must be thrown");		
		} catch (IllegalArgumentException e) {
			//exception thrown, good
		}
		try {										
			page.scrapes("");			
			fail("Exception must be thrown");		
		} catch (IllegalArgumentException e) {
			//exception thrown, good
		}
	}
	
	@Test
	public void testScrapes_empty() {
		ProductHtmlPage page = new ProductHtmlPage();
		page.scrapes("<html/>");
		assertTrue("".equals(page.getDescription()));
		assertNull(page.getTitle());
		assertTrue(("<html/>".length() / 1024f) == page.getKbPageSize());
		assertTrue(0f == page.getUnitPrice());
	}
	
	@Test
	public void testScrapes() throws Exception {
		ProductHtmlPage page = new ProductHtmlPage();		
		String html = readFile("product1.html", Charset.forName("UTF-8"));
		assertNotNull(html);				
		page.scrapes(html);
		
		assertTrue(("Buy Sainsbury's Apricot Ripe & Ready x5 online from Sainsbury's, the same great quality, " +
				"freshness and choice you'd find in store. Choose from 1 hour delivery slots and collect Nectar " +
				"points.").equals(page.getDescription()));		
		assertTrue("Sainsbury's Apricot Ripe & Ready x5 | Sainsbury's".equals(page.getTitle()));		
		assertTrue(39.083984f == page.getKbPageSize());		
		assertTrue(3.5f == page.getUnitPrice());
	}
}

package com.sains.app.screen;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;

import com.sains.app.BaseTestCase;

public class ProductListHtmlPageTest extends BaseTestCase {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testScrapes_notNull() {
		ProductListHtmlPage page = new ProductListHtmlPage();
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
		ProductListHtmlPage page = new ProductListHtmlPage();
		page.scrapes("<html/>");
		assertTrue(page.getProductLinks().isEmpty());		
	}
	

	@Test
	public void testScrapes() throws Exception {
		ProductListHtmlPage page = new ProductListHtmlPage();		
		String html = readFile("productList.html", Charset.forName("UTF-8"));
		assertNotNull(html);				
		page.scrapes(html);
		
		assertTrue(7 == page.getProductLinks().size());		
		assertTrue("http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/sainsburys-apricot-ripe---ready-320g.html".equals(page.getProductLinks().get(0)));
		assertTrue("http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/sainsburys-avocado-xl-pinkerton-loose-300g.html".equals(page.getProductLinks().get(1)));
		assertTrue("http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/sainsburys-avocado--ripe---ready-x2.html".equals(page.getProductLinks().get(2)));
		assertTrue("http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/sainsburys-avocados--ripe---ready-x4.html".equals(page.getProductLinks().get(3)));
		assertTrue("http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/sainsburys-conference-pears--ripe---ready-x4-%28minimum%29.html".equals(page.getProductLinks().get(4)));
		assertTrue("http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/sainsburys-golden-kiwi--taste-the-difference-x4-685641-p-44.html".equals(page.getProductLinks().get(5)));
		assertTrue("http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/sainsburys-kiwi-fruit--ripe---ready-x4.html".equals(page.getProductLinks().get(6)));
		
	}

}

package com.sains.app.screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sains.app.AppProperties;
import com.sains.app.util.HtmlPageUtil;

public class ScreenController {
	
	private static Logger LOG = Logger.getLogger(ScreenController.class.toString());
	private List<ProductHtmlPage> productPages = new ArrayList<>();
	
	public void scrapes() throws IOException {
		//get url from the application properties
		String productListUrl = AppProperties.getProductListUrl();
		LOG.log(Level.FINEST, "productListUrl: " + productListUrl);
		
		//download the html content
		String html = HtmlPageUtil.fetchUrlContent(productListUrl);		
		LOG.log(Level.FINEST, "html: " + html);
		
		ProductListHtmlPage productListPage = new ProductListHtmlPage();
		//scrape the product list page
		productListPage.scrapes(html);
		
		List<String> productLinks = productListPage.getProductLinks();
		for(String link : productLinks) {
			LOG.log(Level.FINEST, "link: " + link);
			html = HtmlPageUtil.fetchUrlContent(link);
			ProductHtmlPage productPage = new ProductHtmlPage();
			productPage.scrapes(html);
			productPages.add(productPage);
		}		
	}

	public List<ProductHtmlPage> getProductPages() {
		return productPages;
	}
	
}

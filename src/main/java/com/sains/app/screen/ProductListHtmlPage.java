package com.sains.app.screen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * This class model the product list html page. Its mapped to the required attributes on the page
 * 
 * @author Admin
 *
 */
public class ProductListHtmlPage implements HtmlPage {
	private static Logger LOG = Logger.getLogger(ProductListHtmlPage.class.toString());
	 
	private List<String> productLinks = new ArrayList<String>();	
	
	public void scrapes(String html) {
		
		if(null == html || html.isEmpty()) {
			throw new IllegalArgumentException("html content cannot be NULL");
		}		
		Document doc = Jsoup.parse(html);
		if(doc != null) {
			Elements productListerElements = doc.select("div#productLister");
			//find the <div id="productLister">
			LOG.log(Level.FINEST, productListerElements.html());
					
			Elements productInfoElements =  productListerElements.select("div.productInfo");
			if(productInfoElements != null) {
				LOG.log(Level.FINEST, productInfoElements.html());
				
				Iterator<Element> iter = productInfoElements.iterator();
				int count = 0;
				while(iter.hasNext()) {
					count++;
					Element e = iter.next();
					//find the link
					Element link = e.select("a").first();
					LOG.log(Level.FINEST, "anchor " + count  + " :" + link.html());
					//extract the href attribute
					String href = link.attr("href");
					LOG.log(Level.FINEST, "Link " + count  + " :" + href);
					productLinks.add(href);			
				}		
			}
		}
	}
	
	public List<String> getProductLinks() {
		return productLinks;
	}
	
	@Override
	public float getKbPageSize() {
		throw new UnsupportedOperationException();
	}
	
}

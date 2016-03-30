package com.sains.app.screen;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * This class model the product html page. Its mapped to the required attributes on the page
 * 
 * 
 * @author Admin
 *
 */

public class ProductHtmlPage implements HtmlPage {
	
	private static Logger LOG = Logger.getLogger(ProductHtmlPage.class.toString());
	private String title;
	private float pageSize;
	private String description;
	private float unitPrice;
	
	public void scrapes(String html) {
		if(null == html || html.isEmpty()) {
			throw new IllegalArgumentException("html content cannot be NULL");
		}
		LOG.log(Level.FINEST, html);
		
		this.pageSize = html.length();
		LOG.log(Level.FINEST, this.pageSize + "kb");
		
		Document doc = Jsoup.parse(html);		
		LOG.log(Level.FINER, doc.html());
		
		//page title
		Elements e = doc.select("title");
		if(e != null && e.first() != null) {
			this.title = e.first().text();		
			LOG.log(Level.FINEST, "title:" + this.title);
		}
		
		//page description
		e = doc.select("meta[name=description]");
		if(e != null) {
			this.description = e.attr("content");
			LOG.log(Level.FINEST, "description:" + this.description);
		}
		
		//pricePerUnit
		e = doc.select("p.pricePerUnit");
		if (e != null &&  e.first() != null) {
			String pricePerUnit = e.first().text();
			//the text comes in the form of "£3.50/unit"		
			LOG.log(Level.FINEST, pricePerUnit);
			//extracts the numeric only
			this.unitPrice = Float.parseFloat(pricePerUnit.substring(1, pricePerUnit.length() - "/unit".length()));
			LOG.log(Level.FINEST,  "price:" + String.valueOf(this.unitPrice));
		}
	}
	
	@Override
	public float getKbPageSize() {
		return pageSize / 1024F;//converting to KByte
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public float getUnitPrice() {
		return unitPrice;
	}
	
	
	
}

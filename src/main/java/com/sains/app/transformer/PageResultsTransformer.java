package com.sains.app.transformer;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;

import com.sains.app.screen.ProductHtmlPage;
import com.sains.app.util.NumberUtil;

/**
 * This class used for transforming ProductHtmlPage objects into JSON objects
 * 
 * 
 * @author Admin
 *
 */
public class PageResultsTransformer {
	
	private List<ProductHtmlPage> productPages;
	
	public void setProductPages(List<ProductHtmlPage> productPages) {
		this.productPages = productPages;
	}
	
	/**
	 * Transform page results into the following required JSON format:
	 * 
	 * 
	 * { "results":[ 
	 * 	{ "title":"Sainsbury's Avocado, Ripe & Ready x2", 
	 * 		"size": "90.6kb", 
	 * 		"unit_price": 1.80, 
	 * 		"description": "Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5..."
	 * 	}, 
	 * 	{ "title":"Sainsbury's Avocado, Ripe & Ready x4", 
	 * 		"size": "87kb",
	 * 		"unit_price": 2.00, 
	 * 		"description":"Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5..."
	 * } ], 
	 * "total": 3.80 }
	 * 
	 * 
	 * @return JSON String  
	 */
	public JsonObject getJSONSObject() {
		 JsonBuilderFactory factory = Json.createBuilderFactory(null);
		 
		 JsonArrayBuilder resultsBuilder = factory.createArrayBuilder();
		 float total = 0;		 
		 for(ProductHtmlPage page: this.productPages) {
			 total += page.getUnitPrice();
			 JsonObject value = factory.createObjectBuilder()
					 .add("title", page.getTitle())
					 .add("size", NumberUtil.numberFormat(page.getKbPageSize()) + "kb")
					 .add("unit_price", NumberUtil.currencyFormat(page.getUnitPrice()))
					 .add("description", page.getDescription())
					 .build();			 
			 resultsBuilder.add(value);
		 }
		 JsonArray results = resultsBuilder.build();
		 
		 JsonObject value = factory.createObjectBuilder()		     
		     .add("results", results)
		     .add("total", NumberUtil.currencyFormat(total))
		     .build();
		 
		return value;		
	}
}

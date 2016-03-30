package com.sains.app;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.json.JsonObject;

import com.sains.app.screen.ScreenController;
import com.sains.app.transformer.PageResultsTransformer;
import com.sains.app.util.JsonFormatUtil;

/**
 * 
 * 
 * @author MK
 *
 */
public class App {
	private static Logger LOG = Logger.getLogger(App.class.toString());
		
	public static void main(String[] args) {
		try {			
			LOG.log(Level.FINEST, "Starting!");
			//scrapes product list page
			ScreenController controller = new ScreenController();
			controller.scrapes();
			
			//transform html page into JSON String representation
			PageResultsTransformer transform = new PageResultsTransformer();
			transform.setProductPages(controller.getProductPages());
			
			JsonObject jsonObject = transform.getJSONSObject();
			
			System.out.println(JsonFormatUtil.prettyFormat(jsonObject));
			LOG.log(Level.FINEST, "Done!");			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}		
	
	
}

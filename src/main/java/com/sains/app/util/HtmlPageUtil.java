package com.sains.app.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class HtmlPageUtil {
	
	/**
	 * Download the content from the given URL
	 * 
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static String fetchUrlContent(String url) throws MalformedURLException, IOException {

		URLConnection con =  new URL(url).openConnection();
		
		final char[] buffer = new char[4 * 1024];
	    final StringBuilder out = new StringBuilder();
	    try (
	    		InputStreamReader in = new InputStreamReader(con.getInputStream(), "UTF-8");	    		
	    	) {
	        for (;;) {
	            int rsz = in.read(buffer, 0, buffer.length);
	            if (rsz < 0) break;
	            out.append(buffer, 0, rsz);
	        }
	    }
	    catch (UnsupportedEncodingException ex) {
	       throw new IOException(ex);
	    }
		return out.toString();
	}
	
	
	
}

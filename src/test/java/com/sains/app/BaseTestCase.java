package com.sains.app;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Ignore;

import com.sains.app.screen.ProductHtmlPageTest;

import junit.framework.TestCase;

@Ignore
public class BaseTestCase extends TestCase {
	/**
	 * Quickly reads in a content of the a small file and converts it to String.
	 * 
	 * @param filename
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	protected static String readFile(String filename, Charset encoding) throws Exception {
		URI path = ProductHtmlPageTest.class.getClassLoader().getResource(filename).toURI();
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
}

package com.sains.app.util;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;

import org.junit.Before;
import org.junit.Test;

public class JsonFormatUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPrettyFormat() throws Exception {
		JsonBuilderFactory factory = Json.createBuilderFactory(null);
		JsonObject jsonObject = factory.createObjectBuilder()
				.add("A", "A")
			    .add("B", "B")
			    .build();
		
		String jsonFormatted = JsonFormatUtil.prettyFormat(jsonObject);
		String hexString = String.format("%x", new BigInteger(1, jsonFormatted.getBytes("UTF-8")));
		//convert unprintable characters into hex value for comparison
		assertTrue("a7b0a202020202241223a2241222c0a202020202242223a2242220a7d".equals(hexString));
		
	}

}

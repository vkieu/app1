package com.sains.app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AppPropertiesTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetProductListUrl() {
		assertNotNull(AppProperties.getProductListUrl());
	}

}

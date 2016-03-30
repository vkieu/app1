package com.sains.app.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NumberUtilTest {

	@Test
	public void testCurrencyFormat() {
		float n = 0f;
		String value = NumberUtil.currencyFormat(n);
		assertTrue("0.00".equals(value));
		
		n = -0.00f;
		value = NumberUtil.currencyFormat(n);
		assertTrue("0.00".equals(value));
		
		n = -0.1f;
		value = NumberUtil.currencyFormat(n);
		assertTrue("-0.10".equals(value));
		
		n = 0.1f;
		value = NumberUtil.currencyFormat(n);
		assertTrue("0.10".equals(value));		
		
	}
	
	@Test
	public void testCurrencyFormat_rounding() {
		float n = 1.109f;
		String value = NumberUtil.currencyFormat(n);
		assertTrue("1.11".equals(value));
		
		n = 1.101f;
		value = NumberUtil.currencyFormat(n);
		assertTrue("1.10".equals(value));
	}
	

	@Test
	public void testNumberFormat() {
		float n = 0f;
		String value = NumberUtil.numberFormat(n);
		assertTrue("0".equals(value));
		
		n = -0.00f;
		value = NumberUtil.numberFormat(n);
		assertTrue("0".equals(value));
		
		n = -0.1f;
		value = NumberUtil.numberFormat(n);
		assertTrue("Value " + value + " is not match", "-0.1".equals(value));
		
		n = 0.1f;
		value = NumberUtil.numberFormat(n);
		assertTrue("0.1".equals(value));		
		
	}

	@Test
	public void testNumberFormat_rounding() {
		float n = 1.109f;
		String value = NumberUtil.numberFormat(n);
		assertTrue("1.11".equals(value));
		
		n = 1.101f;
		value = NumberUtil.numberFormat(n);
		assertTrue("1.1".equals(value));
	}
}

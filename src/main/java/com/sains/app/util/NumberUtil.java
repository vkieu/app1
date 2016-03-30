package com.sains.app.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class NumberUtil {
	private static final String CURRENCY_FORMAT = "##0.00";
	private static final String STANDARD_FORMAT = "##0.##";

	/**
	 * Format currency to 2dp.
	 * 
	 * @param value
	 * @return formatted to 2dp with correct rounding
	 */
	public static String currencyFormat(final float value) {
		DecimalFormat format = new DecimalFormat(CURRENCY_FORMAT);
		format.setRoundingMode(RoundingMode.HALF_UP);
		// remove the -sign for -0.00
		if (value == 0f) {
			return format.format(Math.abs(value));
		}
		return format.format(value);
	}

	/**
	 * Format float number to the standard 2dp.
	 * 
	 * @param value
	 * @return formatted to 2dp with correct rounding
	 */
	public static String numberFormat(final float value) {
		DecimalFormat format = new DecimalFormat(STANDARD_FORMAT);
		format.setRoundingMode(RoundingMode.HALF_UP);
		// remove the -sign for -0.00
		if (value == 0f) {
			return format.format(Math.abs(value));
		}
		return format.format(value);
	}
}

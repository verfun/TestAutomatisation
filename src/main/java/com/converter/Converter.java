package com.converter;

import java.text.DecimalFormat;

public class Converter {
	
	public static String fixDigits(double number) {
		DecimalFormat df = new DecimalFormat ( ) ; 
		df.setMaximumFractionDigits ( 2 ) ; 
		df.setMinimumFractionDigits ( 2 ) ; 
		df.setDecimalSeparatorAlwaysShown ( true ) ;
		return df.format(number);
	}
	public static double convertToFahrenheit(double celesiusDegree) {
		double result = celesiusDegree * 1.8 + 32;
		return Double.parseDouble(fixDigits(result));
	}
	public static double convertToCelesius(double fahrenheitDegree) {
		double result = (fahrenheit - 32) / 1.8;
		return Double.parseDouble(fixDigits(result));
	}

}

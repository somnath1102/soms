package com.somnath;

import org.apache.commons.lang3.StringUtils;

public class CapitaliseFirstLetter {
	
	public static void main(String[] args) {
		String sample = "i am A Very awkWWard String., done HEre@@ oKK kk";
		//sample = "i";
		System.out.println(StringUtils.capitalize(StringUtils.lowerCase(sample)));
	}

}

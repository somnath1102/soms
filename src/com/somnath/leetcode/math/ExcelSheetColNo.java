package com.somnath.leetcode.math;

public class ExcelSheetColNo {
	public static int titleToNumber(String s) {
		if(s == null || s.length() == 0)
			return 0;
		int sum = 0;
		for (char c : s.toCharArray()) {
			sum = 26 * sum + (c - 'A' + 1);
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(titleToNumber("ABC"));
	}
}

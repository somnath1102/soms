package com.somnath.leetcode.strings;

public class IndexOf {

	public static int strStr(String haystack, String needle) {
		if ("".equals(needle))
			return 0;
		if (haystack.length() < needle.length())
			return -1;
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				int j = 1;
				for (; j < needle.length() && haystack.charAt(i + j) == needle.charAt(j); j++)
					;
				if (j == needle.length()) {
					return i;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(strStr("onceuponatime", "time"));
		// System.out.println(strStr("aaabc", "bc"));
	}

}

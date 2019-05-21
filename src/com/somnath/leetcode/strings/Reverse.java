package com.somnath.leetcode.strings;

public class Reverse {
	public static void reverseString(char[] s) {
		if (s == null || s.length < 2)
			return;
		for (int i = 0; i < s.length / 2; i++) {
			char temp = s[i];
			s[i] = s[s.length - i - 1];
			s[s.length - i - 1] = temp;
		}
	}

	public static void main(String[] args) {
		reverseString("hello".toCharArray());
		StringBuilder s = new StringBuilder("hello");
		System.out.println(s.toString());
		System.out.println(s.reverse());
		System.out.println(s.toString());
	}
}

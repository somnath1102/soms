package com.somnath.leetcode.strings;

public class ReverseWords3 {

	public static String reverseWords(String s) {
		s = s.trim();
		char[] c = s.toCharArray();
		int j = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ' || i == c.length -1) {
				int k = (i == c.length -1) ? i : i - 1;
				while (j < k) {
					c[j] = (char) (c[k] + c[j]);
					c[k] = (char) (c[j] - c[k]);
					c[j] = (char) (c[j++] - c[k--]);
				}
				j = i + 1;
			}
		}
		return new String(c);
	}

	public static void main(String[] args) {
		System.out.println(reverseWords("Let's take LeetCode contest"));
	}

}

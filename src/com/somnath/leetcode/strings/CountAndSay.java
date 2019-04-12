package com.somnath.leetcode.strings;

public class CountAndSay {

	public static String countAndSay(int n) {
		String term = "1";

		while (--n > 0) {
			char curr = term.charAt(0);
			int count = 0;
			StringBuilder sb = new StringBuilder();
			for (char c : term.toCharArray()) {
				if (curr == c) {
					count++;
				} else {
					sb.append(count).append(curr);
					curr = c;
					count = 1;
				}
			}
			sb.append(count).append(curr);
			term = sb.toString();
		}
		return term;
	}

	public static void main(String[] args) {
		System.out.println(countAndSay(5));
	}

}

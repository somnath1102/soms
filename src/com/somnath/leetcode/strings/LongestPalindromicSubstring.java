package com.somnath.leetcode.strings;

public class LongestPalindromicSubstring {

	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 2)
			return s;
		char[] input = new char[2 * s.length() - 1];
		int max = Integer.MIN_VALUE;
		int index = -1;
		for (int i = 0, j = 0;; j++) {
			input[i++] = s.charAt(j);
			if (i == input.length)
				break;
			input[i++] = '#';
		}

		for (int i = 0; i < input.length; i++) {
			int size = input[i] == '#' ? 0 : 1;
			int j = input[i] == '#' ? i - 1 : i - 2;
			int k = input[i] == '#' ? i + 1 : i + 2;
			while (j >= 0 && k < input.length) {
				if (input[j] != input[k])
					break;
				size += 2;
				j -= 2;
				k += 2;
			}
			index = Math.max(max, size) > max ? i : index;
			max = Math.max(max, size);
		}
		StringBuilder sb = new StringBuilder();
		int j = input[index] == '#' ? index - 1 : index - 2;
		while (max > 1) {
			sb.append(input[j]);
			j -= 2;
			max -= 2;
		}
		String mirror = sb.toString();
		sb.reverse();
		sb.append(input[index] == '#' ? "" : input[index]);
		sb.append(mirror);

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("dd"));
	}

}

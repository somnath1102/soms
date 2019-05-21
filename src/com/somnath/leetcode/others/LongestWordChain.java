package com.somnath.leetcode.others;

import java.util.Arrays;

// 1048. Longest String Chain
public class LongestWordChain {

	public static void main(String[] args) {
		System.out.println(longestStrChain(new String[] { "ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh",
				"zczvh", "gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru" }));
	}

	public static int longestStrChain(String[] words) {
		if (words.length < 2)
			return 1;
		Arrays.sort(words, (x, y) -> x.length() - y.length());
		int[] dp = new int[words.length];
		int max = -1;
		for (int i = 1; i < dp.length; i++) {
			String curr = words[i];
			for (int j = i - 1; j >= 0; j--) {
				String prev = words[j];
				if (curr.length() == (prev.length() + 1) && ((dp[j] + 1) > dp[i])) {
					if (checkIfPredecessor(curr, prev)) {
						dp[i] = dp[j] + 1;
					}
				}
				max = Math.max(max, dp[i]);
			}
		}
		return max + 1;
	}

	private static boolean checkIfPredecessor(String curr, String prev) {
		if (prev.length() + 1 != curr.length())
			return false;
		int[] lCases = new int[26];
		for (char c : prev.toCharArray()) {
			lCases[c - 'a'] += 1;
		}
		for (char c : curr.toCharArray()) {
			lCases[c - 'a'] -= 1;
		}
		int deviation = 0;
		for (int i = 0; i < lCases.length; i++) {
			if (lCases[i] != 0)
				deviation++;
			if (deviation > 1)
				return false;
		}
		return true;
	}

}

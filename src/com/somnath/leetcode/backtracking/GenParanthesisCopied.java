package com.somnath.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * The key to all backtracking problems is "to choose". You have to choose
 * between many options and then come back to choose again. In this problem, you
 * have to choose between left and right parenthesis. In another backtracking
 * problem:letter-combinations-of-a-phone-number. You have to choose between
 * different letters. These problems share a same pattern. In your helper
 * function, you just need to list all your options and try each one of them
 * out. As for this problem, every time you choose a "(" means making another
 * ")" available.
 *
 */
public class GenParanthesisCopied {

	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		backtrack(list, "", 0, 0, n);
		return list;
	}

	public static void backtrack(List<String> list, String str, int open, int close, int max) {

		if (str.length() == max * 2) {
			list.add(str);
			return;
		}

		if (open < max)
			backtrack(list, str + "(", open + 1, close, max);
		if (close < open)
			backtrack(list, str + ")", open, close + 1, max);
	}

	public static void main(String[] args) {
		for (String str : generateParenthesis(3)) {
			System.out.println(str);
		}
	}

}

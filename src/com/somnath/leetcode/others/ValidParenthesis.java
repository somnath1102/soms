package com.somnath.leetcode.others;

import java.util.LinkedList;

public class ValidParenthesis {

	public static boolean isValid(String s) {
		LinkedList<Character> stack = new LinkedList<>();
		for (char c : s.toCharArray()) {
			if (c == '{' || c == '[' || c == '(') {
				stack.push(c);
			} else {
				if (stack.isEmpty() || complement(c) != stack.pop()) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	private static char complement(char c) {
		char r = ' ';
		switch (c) {
		case ')':
			r = '(';
			break;
		case '}':
			r = '{';
			break;
		case ']':
			r = '[';
			break;
		default:
			r = ' ';
		}
		return r;
	}

	public static void main(String[] args) {
		System.out.println(isValid(")"));
	}

}

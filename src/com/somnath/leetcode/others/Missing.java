package com.somnath.leetcode.others;

import java.util.Stack;

public class Missing {
	public static int missingNumber(int[] nums) {
		int result = 0;
		for (int num : nums) {
			result += num;
		}
		return ((nums.length * (nums.length + 1)) / 2 - result);
	}

	public static void main(String[] args) {
		Stack<Character> s = new Stack<>();
		System.out.println(s.pop());
	}
}

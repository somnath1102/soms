package com.somnath.leetcode.dynamic.programming;

public class LongestIncreasingSubsequence {
	
	// DP - for each element go left and find max of the length at any elements less than current element.
	// can be improved by storing the left side in a tree
	public static int lengthOfLIS(int[] nums) {
		int[] r = new int[nums.length];
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			int maxL = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] < nums[i]) {
					maxL = Math.max(r[j], maxL);
				}
			}
			r[i] = 1 + maxL;
			max = Math.max(r[i], max);
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int [] {10,9,2,5,3,7,101,18}));
	}

}

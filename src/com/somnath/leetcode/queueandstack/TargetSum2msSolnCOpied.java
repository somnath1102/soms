package com.somnath.leetcode.queueandstack;

import java.util.Arrays;

public class TargetSum2msSolnCOpied {

	public static int findTargetSumWays(int[] nums, int S) {
		int sum = 0;

		for (int n : nums) {
			sum += n;
		}

		return sum < S || (S + sum) % 2 > 0 ? 0 : subsetSum(nums, (S + sum) / 2);
	}

	public static int subsetSum(int[] nums, int s) {
		int[] dp = new int[s + 1];
		dp[0] = 1;
		System.out.println("input" + Arrays.toString(nums));
		for (int num : nums) {
			for (int j = s; j >= num; j--) {
				dp[j] += dp[j - num];
				System.out.println(Arrays.toString(dp));
			}
		}
		System.out.println("soln--------" + dp[s] + ":" + s);
		return dp[s];
	}

	public static void main(String[] args) {
		System.out.println(findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3));
	}

}

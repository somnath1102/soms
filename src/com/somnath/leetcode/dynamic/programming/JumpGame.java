package com.somnath.leetcode.dynamic.programming;

public class JumpGame {

	public static boolean canJump(int[] nums) {
		boolean[] dp = new boolean[nums.length];
		dp[0] = true;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i]) {
				for (int j = nums[i], k = i; j > 0 && (k + 1) < dp.length; j--, k++) {
					dp[k + 1] = true;
				}
			}
		}
		
		return dp[dp.length - 1];
	}

	public static void main(String[] args) {
		System.out.println(canJump(new int[] { 0,2,3 }));
		System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(canJump(new int[] { 3, 2, 1, 0, 4 }));
	}

}

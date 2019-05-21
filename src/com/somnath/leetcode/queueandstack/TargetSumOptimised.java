package com.somnath.leetcode.queueandstack;


public class TargetSumOptimised {

	public static void main(String[] args) {
		TargetSumOptimised ts = new TargetSumOptimised();
//		System.out.println(ts.findTargetSumWays(new int[] { 1, 2, 1 }, 0));
		 System.out.println(ts.findTargetSumWays(new int[] { 1, 1, 1, 1, 1 },
		 3));
		// System.out.println(ts.findTargetSumWays(new int[] { 27, 22, 39, 22,
		// 40, 32, 44, 45, 46, 8, 8, 21, 27, 8, 11, 29, 16, 15, 41, 0 },
		// 10));
	}

	public int findTargetSumWays(int[] nums, int targetSum) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1) {
			return Math.abs(nums[0]) == Math.abs(targetSum) ? 1 : 0;
		}
		int[] prev = new int[] { nums[0] };
		int[] curr;
		for (int i = 1; i < nums.length; i++) {
			curr = new int[(int) Math.pow(2, i)];
			for (int j = 0, k = 0; j < prev.length; j++) {
				curr[k++] = prev[j] + nums[i];
				curr[k++] = prev[j] - nums[i];
			}
			prev = curr;
		}
		int count = 0;
		for (Integer val : prev) {
			if (Math.abs(targetSum) == Math.abs(val))
				count++;
		}
		return targetSum == 0 ? count << 1 : count;
	}
}

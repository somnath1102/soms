package com.somnath.leetcode.strings;

public class MinSizeSubArraySum {

	public static int minSubArrayLen(int s, int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		if(nums[0] >= s)
			return 1;
		int i = 0;
		int[] R = new int[nums.length];
		R[0] = nums[0];
		int min = Integer.MAX_VALUE;
		for (int j = 1; j < nums.length; j++) {
			R[j] = R[j - 1] + nums[j];
			int sum = (i == 0) ? R[j] : R[j] - R[i - 1];
			if (sum >= s) {
				min = Math.min(min, j - i + 1);
				i++;
				j--;
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	public static void main(String[] args) {
		System.out.println(minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
	}

}

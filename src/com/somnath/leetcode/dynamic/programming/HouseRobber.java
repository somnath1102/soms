package com.somnath.leetcode.dynamic.programming;

public class HouseRobber {

	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length < 3)
			return nums[0] > nums[1] ? nums[0] : nums[1];
		int[] maxLoot = new int[nums.length];
		nums[2] = nums[0] + nums[2];
		for (int i = 3; i < maxLoot.length; i++) {
			nums[i] += Math.max(nums[i - 2], nums[i - 3]);
		}

		return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
	}

}

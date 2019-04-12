package com.somnath.leetcode.binary.search;

public class SearchRotatedArray {

	public static int search(int[] nums, int target) {
		return search(nums, target, 0, nums.length - 1);
	}

	private static int search(int[] nums, int target, int left, int right) {
		if (nums.length == 0 || (left > right))
			return -1;
		if (left == right) {
			if (nums[left] == target)
				return left;
			else
				return -1;
		}

		// border cases
		if (nums[right] == target)
			return right;
		if (nums[left] == target)
			return left;
		int medianIdx = (left + right) / 2;
		if (nums[medianIdx] == target)
			return medianIdx;

		if (nums[left] < nums[medianIdx]) {
			if (target < nums[left] || target > nums[medianIdx])
				return search(nums, target, medianIdx + 1, right);
			else
				return search(nums, target, left, medianIdx);
		} else {
			if (target < nums[medianIdx] || target > nums[left])
				return search(nums, target, left, medianIdx);
			else
				return search(nums, target, medianIdx + 1, right);
		}
	}

	public static void main(String[] args) {
		int[] input = new int[] { 5, 1, 3 };
		int target = 5;
		System.out.println(search(input, target));
	}

}

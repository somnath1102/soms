package com.somnath.leetcode.strings;

import com.somnath.leetcode.binary.tree.TreeNode;

public class SortedArrayToBST {

	public static TreeNode sortedArrayToBST(int[] nums) {
		return process(0, nums.length - 1, nums);
	}

	private static TreeNode process(int left, int right, int[] nums) {
		if (left == right)
			return new TreeNode(nums[left]);
		if (left > right)
			return null;
		int mid = (right - left) % 2 == 0 ? (right - left) / 2 + left : (right - left) / 2 + left + 1;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = process(left, mid - 1, nums);
		root.right = process(mid + 1, right, nums);
		return root;
	}

	public static void main(String[] args) {
		TreeNode sortedArrayToBST = sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 });
		System.out.println("done");
	}

}

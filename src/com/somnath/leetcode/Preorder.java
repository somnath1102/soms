package com.somnath.leetcode;

public class Preorder {

	public static void preorderTraversal(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.val);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}

}

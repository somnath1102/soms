package com.somnath.leetcode;

public class Inorder {

	public static void preorderTraversal(TreeNode root) {
		if (root == null)
			return;
		preorderTraversal(root.left);
		preorderTraversal(root.right);
		System.out.println(root.val);
	}

}

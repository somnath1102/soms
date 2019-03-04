package com.somnath.leetcode;

public class Postorder {

	public static void preorderTraversal(TreeNode root) {
		if (root == null)
			return;
		preorderTraversal(root.left);
		System.out.println(root.val);
		preorderTraversal(root.right);
	}

}

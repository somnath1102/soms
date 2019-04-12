package com.somnath.leetcode.binary.tree;


public class Postorder {

	public static void postorderTraversal(TreeNode root) {
		if (root == null)
			return;
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.println(root.val);
	}

}

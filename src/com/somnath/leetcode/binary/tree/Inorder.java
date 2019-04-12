package com.somnath.leetcode.binary.tree;

public class Inorder {

	public static void inorderTraversal(TreeNode root) {
		if (root == null)
			return;
		inorderTraversal(root.left);
		System.out.println(root.val);
		inorderTraversal(root.right);
	}

	// This will print in reverse
	public static void revInorderTraversal(TreeNode root) {
		if (root == null)
			return;
		revInorderTraversal(root.right);
		System.out.print(root.val + ", ");
		revInorderTraversal(root.left);
	}

}

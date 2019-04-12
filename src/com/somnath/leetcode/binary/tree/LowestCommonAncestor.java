package com.somnath.leetcode.binary.tree;

public class LowestCommonAncestor {
	// p, q are not null and exist in tree
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (root == p || root == q) {
			return root;
		}
		if (exists(root.left, p) && exists(root.left, q))
			return lowestCommonAncestor(root.left, p, q);
		else if (exists(root.right, p) && exists(root.right, q)) {
			return lowestCommonAncestor(root.right, p, q);
		} else
			return root;
	}

	private static boolean exists(TreeNode node, TreeNode searchObj) {
		if (node == null)
			return false;
		if (node == searchObj)
			return true;
		return exists(node.left, searchObj) || exists(node.right, searchObj);
	}

}

package com.somnath.leetcode.binary.tree;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isMirror(root.left, root.right);
	}

	private boolean isMirror(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null)
			return true;
		if (node1 == null || node2 == null)
			return false;
		if (node1.val == node2.val) {
			return isMirror(node1.left, node2.right) && isMirror(node2.left, node1.right);
		}
		return false;
	}
}

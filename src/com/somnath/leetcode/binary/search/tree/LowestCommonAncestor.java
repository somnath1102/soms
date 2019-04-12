package com.somnath.leetcode.binary.search.tree;

import com.somnath.leetcode.binary.tree.TreeNode;

public class LowestCommonAncestor {
	// p, q are not null and exist in tree
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (p.val < root.val && q.val < root.val)
			return lowestCommonAncestor(root.left, p, q);
		else if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else
			return root;
	}

}

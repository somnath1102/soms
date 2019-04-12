package com.somnath.leetcode.binary.search.tree;

import com.somnath.leetcode.binary.tree.TreeNode;

public class CreateBST {
	public static TreeNode insert(TreeNode root, int i) {
		if (root == null) {
			root = new TreeNode(i);
			return root;
		}
		TreeNode curr = root;
		TreeNode prev = null;
		while (curr != null) {
			prev = curr;
			if (curr.val >= i)
				curr = curr.left;
			else
				curr = curr.right;
		}
		if (i > prev.val)
			prev.right = new TreeNode(i);
		else
			prev.left = new TreeNode(i);

		return root;
	}

}

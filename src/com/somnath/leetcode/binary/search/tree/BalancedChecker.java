package com.somnath.leetcode.binary.search.tree;

import com.somnath.leetcode.binary.tree.CreateTree;
import com.somnath.leetcode.binary.tree.TreeNode;

public class BalancedChecker {

	public static boolean isBalanced(TreeNode node) {
		if (node == null)
			return true;
		if (Math.abs(maxheight(node.left) - maxheight(node.right)) > 1)
			return false;
		return isBalanced(node.left) && isBalanced(node.right);
	}

	private static int maxheight(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + Math.max(maxheight(node.left), maxheight(node.right));
	}

	public static void main(String[] args) {
		System.out.println(isBalanced(CreateTree.createTree(new Integer[] { 1, null, 3, null, null, 7, 8 })));
	}
}

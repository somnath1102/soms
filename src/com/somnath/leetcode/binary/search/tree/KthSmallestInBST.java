package com.somnath.leetcode.binary.search.tree;

import com.somnath.leetcode.binary.tree.TreeNode;

public class KthSmallestInBST {

	static int count = 0;

	public static int kthSmallest(TreeNode root, int k) {
		count = k;
		return traverseInorderKTimes(root);
	}

	private static int traverseInorderKTimes(TreeNode node) {
		if (node == null)
			return 0;
		int val = traverseInorderKTimes(node.left);
		if (count == 0)
			return val;
		if (--count == 0)
			return node.val;
		return traverseInorderKTimes(node.right);
	}

	public static void main(String[] args) {
		TreeNode t = new TreeNode(3);
		CreateBST.insert(t, 5);
		CreateBST.insert(t, 10);
		CreateBST.insert(t, 9);
		CreateBST.insert(t, 4);
		CreateBST.insert(t, 1);
		System.out.println(KthSmallestInBST.kthSmallest(t, 5));
	}
}

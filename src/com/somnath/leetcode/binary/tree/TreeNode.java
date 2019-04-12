package com.somnath.leetcode.binary.tree;

public class TreeNode {
	public int val;

	public TreeNode left;
	public TreeNode right;
	
	public TreeNode next;

	public TreeNode() {
	}

	public TreeNode(int x) {
		val = x;
	}
	
	public TreeNode(int _val, TreeNode _left, TreeNode _right, TreeNode _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
}
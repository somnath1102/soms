package com.somnath.leetcode.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CreateTree {
	/**
	 * Note this creates a binary tree, not a search tree
	 * @param input
	 * @return
	 */
	public static TreeNode createTree(Integer[] input) {
		if (input == null) {
			input = new Integer[] { 3, 9, 20, null, null, 15, 7 };
		}
		TreeNode root = new TreeNode(input[0]);
		if (input.length == 1) {
			return root;
		}
		if (input.length == 2) {
			root.left = input[1] == null ? null : new TreeNode(input[1]);
			return root;
		}
		Queue<TreeNode> treeQ = new LinkedList<TreeNode>();
		treeQ.offer(root);
		for (int j = 0; j < input.length / 2; j++) {
			TreeNode node = treeQ.poll();
			if(node != null) {
				node.left = input[j * 2 + 1] == null ? null : new TreeNode(input[j * 2 + 1]);
				node.right = input[j * 2 + 2] == null ? null : new TreeNode(input[j * 2 + 2]);
				treeQ.offer(node.left);
				treeQ.offer(node.right);
			} else {
				treeQ.offer(null);
				treeQ.offer(null);
			}
			
		}
		return root;
	}

}

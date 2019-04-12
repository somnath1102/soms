package com.somnath.leetcode.binary.search.tree;

import com.somnath.leetcode.binary.tree.CreateTree;
import com.somnath.leetcode.binary.tree.TreeNode;

public class NodeDeletion {

	TreeNode prev;
	TreeNode curr;

	public TreeNode deleteNode(TreeNode root, int key) {
		search(null, root, key);
		if (curr == null) {
			System.out.println("Key not found - exiting.");
			return root;
		}
		// case delete when no child
		if (curr.left == null && curr.right == null) {
			// if deleting a one node tree
			if(prev == null)
				return null;
			
			if (prev.left == curr)
				prev.left = null;
			else
				prev.right = null;
			return root;
		}

		// case when one child
		if (curr.left == null || curr.right == null) {
			if(prev == null)
				return curr.left == null ? curr.right : curr.left;
			if (prev.left == curr)
				prev.left = curr.left == null ? curr.right : curr.left;
			else
				prev.right = curr.left == null ? curr.right : curr.left;
			return root;
		}

		// case when two child - replace with successor i.e. leftest on the
		// right(optionally predecessor)
		// will resuse or curr and prev to find the one to replace with
		TreeNode toDelete = curr;
		prev = null;
		curr = curr.right;
		while (curr.left != null) {
			prev = curr;
			curr = curr.left;
		}
		toDelete.val = curr.val;
		if (prev == null) {
			toDelete.right = curr.right;
		} else {
			prev.left = curr.right;
		}

		return root;
	}

	private void search(TreeNode prev, TreeNode node, int key) {
		if (node == null)
			return;
		if (key == node.val) {
			curr = node;
			this.prev = prev;
		}
		if (key < node.val) {
			search(node, node.left, key);
		} else {
			search(node, node.right, key);
		}
	}

	public static void main(String[] args) {
		NodeDeletion nd = new NodeDeletion();
//		TreeNode root = nd.deleteNode(
//				CreateTree.createTree(new Integer[] { 50, 20, 60, 10, 40, 55, 70, null, null, 30, null, null, 57, null, null }),
//				20);
		TreeNode root = nd.deleteNode(
				CreateTree.createTree(new Integer[] {5,3,6,2,4,null,7}),
				5);
		System.out.println(root.val);
	}
}

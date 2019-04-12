package com.somnath.leetcode.binary.search.tree;

import java.util.Iterator;
import java.util.LinkedList;

import com.somnath.leetcode.binary.tree.CreateTree;
import com.somnath.leetcode.binary.tree.TreeNode;

class BSTIterator {
	private LinkedList<TreeNode> inorderList = new LinkedList<>();
	private Iterator<TreeNode> iterator;

	public BSTIterator(TreeNode root) {
		buildList(root);
	}

	private void buildList(TreeNode node) {
		if (node == null)
			return;
		buildList(node.left);
		inorderList.add(node);
		buildList(node.right);
		iterator = inorderList.iterator();
	}

	/** @return the next smallest number */
	public int next() {
		return iterator.next().val;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if(iterator == null)
			return false;
		return iterator.hasNext();
	}

	public static void main(String[] args) {
		BSTIterator bst = new BSTIterator(CreateTree.createTree(new Integer[] { 7, 3, 15, null, null, 9, 20 }));
		System.out.println(bst.next());
		System.out.println(bst.next());
		System.out.println(bst.next());
		System.out.println(bst.next());
		System.out.println(bst.next());
	}
}

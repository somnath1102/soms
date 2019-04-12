package com.somnath.leetcode.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

// does bfs as the next if not calculated per level may not be available at a lower level
public class NextRightPointers {

	public static TreeNode connect(TreeNode tree) {
		if (tree == null)
			return null;
		if (tree.left == null && tree.right == null)
			return tree;

		Queue<TreeNode> levelWiseNodes = new LinkedList<>();
		levelWiseNodes.offer(tree);

		TreeNode root = tree;
		while (root != null) {
			if (root.left != null) {
				levelWiseNodes.offer(root.left);
			}
			if (root.right != null) {
				levelWiseNodes.offer(root.right);
			}

			if (root.left != null) {
				if (root.right != null)
					root.left.next = root.right;
				else if (root.next != null) {
					TreeNode currNext = root.next;
					while (currNext != null) {
						if (currNext.left != null) {
							root.left.next = currNext.left;
							currNext = null;
						} else if (currNext.right != null) {
							root.left.next = currNext.right;
							currNext = null;
						} else
							currNext = currNext.next;
					}
				}
			}

			if (root.right != null) {
				if (root.next != null) {
					TreeNode currNext = root.next;
					while (currNext != null) {
						if (currNext.left != null) {
							root.right.next = currNext.left;
							currNext = null;
						} else if (currNext.right != null) {
							root.right.next = currNext.right;
							currNext = null;
						} else
							currNext = currNext.next;
					}
				}
			}
			
			root = levelWiseNodes.poll();
		}

		return tree;
	}

	public static void main(String[] args) {
		TreeNode tree = CreateTree.createTree(new Integer[] { 1, 2, 9, 3, 5, 10, 11, 4, null, 6, 7, null, null, 12, 13, 8, null, null,
				null, null, null, null, 8, null, null, null, null });
		// Preorder.preorderTraversal(root);
		System.out.println();
		// Inorder.inorderTraversal(root);
		Postorder.postorderTraversal(tree);
		connect(tree);
		System.out.println();
	}
}

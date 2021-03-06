package com.somnath.leetcode.binary.tree;

import java.util.Arrays;

/**
 * The idea behind this is in the leetcde discussion. Basically preorder will
 * print the root first. So in inorder array we can find the root by looking for
 * the inorder element which occurs first in preorder array. Once we get the
 * root , left and subtree lie on wither side of the inorder array - as it
 * traverses Left Root Right. Using recursion we solve it
 * 
 * This can be more memory friendly if we use indexes instead of array copy
 * 
 * @author mukherj9
 *
 */
public class BinaryTreeFromPostorderInorder {

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || inorder.length == 0)
			return null;
		// find what occurs last in post among inorder
		int rootIdxInorder = -1;
		for (int i = postorder.length - 1; i >= 0 && rootIdxInorder == -1; i--) {
			for (int j = 0; j < inorder.length; j++) {
				if (postorder[i] == inorder[j]) {
					rootIdxInorder = j;
					break;
				}
			}
		}
		TreeNode root = new TreeNode(inorder[rootIdxInorder]);
		root.left = buildTree(Arrays.copyOfRange(inorder, 0, rootIdxInorder), postorder);
		root.right = buildTree(Arrays.copyOfRange(inorder, rootIdxInorder + 1, inorder.length), postorder);
		return root;
	}

	public static void main(String[] args) {
		Preorder.preorderTraversal(buildTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 }));
		System.out.println();
		Postorder.postorderTraversal(buildTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 }));
		System.out.println();
		Inorder.inorderTraversal(buildTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 }));
	}

}

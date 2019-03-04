package com.somnath.leetcode;

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
public class BinaryTreeFromPreorderInorder {

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder == null || inorder.length == 0)
			return null;
		// find what occurs first in pre among in
		int rootIdxInorder = -1;
		for (int i = 0; i < preorder.length && rootIdxInorder == -1; i++) {
			for (int j = 0; j < inorder.length; j++) {
				if (preorder[i] == inorder[j]) {
					rootIdxInorder = j;
					break;
				}
			}
		}
		TreeNode root = new TreeNode(inorder[rootIdxInorder]);
		root.left = buildTree(preorder, Arrays.copyOfRange(inorder, 0, rootIdxInorder));
		root.right = buildTree(preorder, Arrays.copyOfRange(inorder, rootIdxInorder + 1, inorder.length));
		return root;
	}

	public static void main(String[] args) {
		Preorder.preorderTraversal(buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 }));
		System.out.println();
		Postorder.preorderTraversal(buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 }));
		System.out.println();
		Inorder.preorderTraversal(buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 }));
	}

}

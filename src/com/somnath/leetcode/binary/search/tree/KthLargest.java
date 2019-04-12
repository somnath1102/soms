package com.somnath.leetcode.binary.search.tree;

import com.somnath.leetcode.binary.tree.TreeNode;

public class KthLargest {

	TreeNode root;
	int kthlargestIdx = -1;
	int kthlargestVal = -1;

	public KthLargest(int k, int[] nums) {
		kthlargestIdx = k;
		for (int i : nums) {
			root = CreateBST.insert(root,i);
		}
	}

	
	public int add(int val) {
		kthlargestVal = -1;
		root = CreateBST.insert(root,val);
		traverseInorderReversed(root, kthlargestIdx);
		return kthlargestVal;
	}

	private int traverseInorderReversed(TreeNode node, int count) {
		if (node != null && kthlargestVal < 0) {
			count = traverseInorderReversed(node.right, count);
//			System.out.print(node.val + ", ");
			if (--count == 0) {
				kthlargestVal = node.val;
				return count;
			}
			count = traverseInorderReversed(node.left, count);
		}
		return count;
	}

	
	public static void main(String[] args) {
//		int y = 10;
//		System.out.println(1+ y >> 1);
//		System.out.println(y );
//		KthLargest k = new KthLargest(3, new int[] { 1,1});
//		System.out.println(k.add(1));
		
		KthLargest k = new KthLargest(3, new int[] { 4, 5, 8, 2 });
		System.out.println(k.add(3));
		System.out.println(k.add(5));
		System.out.println(k.add(10));
		System.out.println(k.add(9));
		System.out.println(k.add(4));
		
	}

}

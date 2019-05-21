package com.somnath.leetcode.queueandstack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TargetSum {

	public static void main(String[] args) {
		TargetSum ts = new TargetSum();
		System.out.println(ts.findTargetSumWays(new int[] { 1, 2, 3 }, 3));
		//System.out.println(ts.findTargetSumWays(new int[] { 1, 1, 1, 1, 1 },3));
//		System.out.println(ts.findTargetSumWays(new int[] { 27, 22, 39, 22, 40, 32, 44, 45, 46, 8, 8, 21, 27, 8, 11, 29, 16, 15, 41, 0 },
//				10));
	}

	int targetSum;
	int count;

	public int findTargetSumWays(int[] nums, int targetSum) {
		this.targetSum = targetSum;
		return buildTree(nums);
	}

	private int dfs(Node root) {
		Stack<Node> s = new Stack<>();
		int count = 0;
		s.push(root);
		root.sum = root.val;
		while (!s.isEmpty()) {
			Node t = s.pop();
			if (t.left == null) {
				if (t.sum == targetSum)
					count++;
			} else {
				s.push(t.left);
				t.left.sum = t.sum + t.left.val;
				s.push(t.right);
				t.right.sum = t.sum + t.right.val;
			}
		}
		return count;
	}

	private int buildTree(int[] nums) {
		Node root = new Node(0);
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		root.sum = root.val;
		int numsIdx = 0;
		while (numsIdx < nums.length) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node parent = q.poll();
				q.offer(parent.left = new Node(nums[numsIdx]));
				parent.left.sum = parent.left.val + parent.sum;
				q.offer(parent.right = new Node(-nums[numsIdx]));
				parent.right.sum = parent.right.val + parent.sum;
			}
			numsIdx++;
		}

		while (!q.isEmpty()) {
			if (q.poll().sum == targetSum)
				count++;
		}
		return count;
	}

	static class Node {
		final int val;
		int sum;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "Node [val=" + val + ", sum=" + sum + "]";
		}
	}

}

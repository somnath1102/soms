package com.somnath.leetcode.binary.search;

import java.util.PriorityQueue;

public class KthLargestInUnsortedArray {
	// keep a min heap of the k largest - by default comparator of PriorityQ for
	// integers is min
	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> p = new PriorityQueue<>(k);

		for (int i = 0; i < nums.length; i++) {
			if (p.size() == k) {
				if (nums[i] > p.peek()) {
					p.poll();
					p.add(nums[i]);
				}
			} else {
				p.add(nums[i]);
			}
		}
		return p.peek();
	}

	public static void main(String[] args) {
		System.out.println("soln : " + findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
	}

}

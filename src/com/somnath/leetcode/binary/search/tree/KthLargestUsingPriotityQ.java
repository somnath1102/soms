package com.somnath.leetcode.binary.search.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestUsingPriotityQ {
	
	private PriorityQueue<Integer> pq;
	private final int k;

	public KthLargestUsingPriotityQ(int k, int[] nums) {
		this.k = k;
		pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i : nums) {
			pq.offer(i);
		}
	}

	public int add(int val) {
		pq.add(val);
		int count = k;
		List<Integer> l = new ArrayList<>();
		while (--count >= 0) {
			l.add(pq.poll());
		}
		int kthlargest = -1;
		for (Integer again : l) {
			pq.add(again);
			kthlargest = again;
		}
		return kthlargest;
	}

	
	public static void main(String[] args) {
		KthLargestUsingPriotityQ k = new KthLargestUsingPriotityQ(1, new int[] {-2});
		System.out.println(k.add(-3));
		System.out.println(k.add(0));
		System.out.println(k.add(2));
		System.out.println(k.add(-1));
		System.out.println(k.add(4));

		// KthLargestUsingHeap k = new KthLargestUsingHeap(3, new int[] { 4, 3,
		// 2 });
		// k.insert(8);
		// System.out.println(k.poll());
	}

}

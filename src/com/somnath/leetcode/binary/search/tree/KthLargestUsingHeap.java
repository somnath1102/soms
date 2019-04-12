package com.somnath.leetcode.binary.search.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthLargestUsingHeap {

	private int[] maxHeap;
	private int size = 0;
	private final int k;

	public KthLargestUsingHeap(int k, int[] nums) {
		this.k = k;
		maxHeap = new int[nums.length + nums.length / 2];
		heapify(nums);
	}

	private void heapify(int[] nums) {
		int newSize = size + nums.length;
		if (newSize > maxHeap.length)
			growTo(newSize);
		for (int num : nums) {
			insert(num);
		}
		size = newSize;
	}

	private void insert(int num) {
		if (size >= maxHeap.length) {
			growTo(size);
		}
		int val = num;
		int childIdx = size;
		int parentIdx = childIdx;
		maxHeap[size++] = val;
		while (parentIdx > 0) {
			parentIdx = --parentIdx >> 1;
			if (maxHeap[parentIdx] < maxHeap[childIdx]) {
				int temp = maxHeap[parentIdx];
				maxHeap[parentIdx] = maxHeap[childIdx];
				maxHeap[childIdx] = temp;
				childIdx = parentIdx;
			} else {
				break;
			}
		}

	}

	private void growTo(int size) {
		// have a 50 %buffer
		size = size < 10 ? 10 : size;
		maxHeap = Arrays.copyOf(maxHeap, size + size / 2);
	}

	public int add(int val) {
		insert(val);
		int count = k;
		List<Integer> l = new ArrayList<>();
		while (--count >= 0) {
			l.add(poll());
		}
		int kthlargest = -1;
		for (Integer again : l) {
			insert(again);
			kthlargest = again;
		}
		return kthlargest;
	}

	private int poll() {
		int max = maxHeap[0];
		int last = maxHeap[--size];
		maxHeap[0] = last;
		maxHeap[size] = 0;
		int pIdx = 0;
		while ((pIdx << 1) + 1 <= (size - 1)) {
			int lChildIdx = (pIdx << 1) + 2 > size - 1 ? (pIdx << 1) + 1
					: maxHeap[(pIdx << 1) + 1] > maxHeap[(pIdx << 1) + 2] ? 1 + (pIdx << 1) : 2 + (pIdx << 1);
			if (maxHeap[pIdx] < maxHeap[lChildIdx]) {
				int temp = maxHeap[pIdx];
				maxHeap[pIdx] = maxHeap[lChildIdx];
				maxHeap[lChildIdx] = temp;
				pIdx = lChildIdx;
			} else {
				break;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		KthLargestUsingHeap k = new KthLargestUsingHeap(1, new int[] {-2});
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

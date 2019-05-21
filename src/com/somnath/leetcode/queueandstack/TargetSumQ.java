package com.somnath.leetcode.queueandstack;

import java.util.LinkedList;
import java.util.Queue;

public class TargetSumQ {

	public static void main(String[] args) {
		TargetSumQ ts = new TargetSumQ();
		System.out.println(ts.findTargetSumWays(new int[] { 1, 1, 1, 1, 1 },3));
//		System.out.println(ts.findTargetSumWays(new int[] { 1, 2, 3 }, 3));
		// System.out.println(ts.findTargetSumWays(new int[] { 27, 22, 39, 22,
		// 40, 32, 44, 45, 46, 8, 8, 21, 27, 8, 11, 29, 16, 15, 41, 0 },
		// 10));
	}

	int targetSum;
	int count;

	public int findTargetSumWays(int[] nums, int targetSum) {
		this.targetSum = targetSum;
		Queue<Integer> s = new LinkedList<>();
		s.offer(nums[0]);
		s.offer(-nums[0]);
		for (int i = 1; i < nums.length; i++) {
			int size = s.size();
			for (int j = 0; j < size; j++) {
				Integer pop = s.poll();
				s.offer(nums[i] + pop);
				s.offer(-nums[i] + pop);
			}
		}
		while (!s.isEmpty()) {
			if (s.poll() == targetSum)
				count++;
		}

		return count;
	}

}

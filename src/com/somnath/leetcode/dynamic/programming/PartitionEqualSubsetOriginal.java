package com.somnath.leetcode.dynamic.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionEqualSubsetOriginal {

	public static boolean canPartition(int[] nums) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i : nums) {
			sum += i;
			if (max < i)
				max = i;
		}
		// choose a number not in the array
		max = max == 0 ? max + 2 : max + 1;
		// sum is odd - cant have equal subsets
		if ((sum & 1) == 1)
			return false;

		// start the game - we are also trying to remember the subset
		sum /= 2;
		int[] dp = new int[sum + 1];
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int num : nums) {
			int dpX[] = new int[sum + 1];
			Arrays.fill(dpX, max);
			for (int i = 0; i + num <= sum; i++) {
				if (dp[i] != max) {
					dpX[i + num] = num;
				}
			}
			// pick up the previous and not overridden visits also
			for (int i = 0; i < dpX.length; i++) {
				if (dpX[i] == max) {
					dpX[i] = dp[i];
				}
			}
			dp = dpX;
			System.out.println(Arrays.toString(dp));
		}
		List<Integer> l = findSubset(dp);
		System.out.println("Subset: " + l.toString());

		return dp[sum] != max;
	}

	static List<Integer> findSubset(int[] dp) {
		List<Integer> l = new ArrayList<Integer>();
		int idx = dp.length - 1;
		while (idx > 0) {
			l.add(dp[idx]);
			idx = idx - dp[idx];
		}
		return l;
	}

	public static void main(String[] args) {
		// System.out.println(canPartition(new int[] { 1, 3, 5, 2, 7 }));
		// System.out.println(canPartition(new int[] { 1, 1, 1, 1 }));
		System.out.println(canPartition(new int[] { -1, -1, -1, -1 }));
	}

}

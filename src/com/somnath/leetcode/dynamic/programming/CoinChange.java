package com.somnath.leetcode.dynamic.programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoinChange {

	public static int coinChangeWIthCombination(int[] coins, int amount) {
		long start = System.currentTimeMillis();
		if (amount == 0)
			return 0;
		if (coins == null || coins.length == 0)
			return -1;
		List<Integer>[] r = new List[amount + 1];
		for (int i = 1; i <= amount; i++) {
			if (contains(coins, i)) {
				r[i] = Collections.singletonList(i);
			} else {
				List<Integer> minList = null;
				int min = Integer.MAX_VALUE;
				// pick up r[j] and r[i-j] and merge - keep track of the min sized list to reach the sum of i
				for (int j = i - 1; j >= (i + 1) / 2; j--) {
					if (r[j] != null && r[i - j] != null) {
						// merge the two for a possible i sum
						List<Integer> p = new ArrayList<>(r[j]);
						p.addAll(r[i - j]);
						minList = Math.min(min, p.size()) == min ? minList : p;
						min = Math.min(min, p.size());
					}
				}
				r[i] = minList;
			}
		}
		// System.out.println("time elapsed in ms:" + TimeUnit.MILLISECONDS.convert(System.nanoTime() - start, TimeUnit.NANOSECONDS));
		System.out.println("time elapsed in ms:" + (System.currentTimeMillis() - start));
		return r[amount] == null ? -1 : r[amount].size();
	}

	public static int coinChange(int[] coins, int amount) {
		long start = System.currentTimeMillis();
		if (amount == 0)
			return 0;
		if (coins == null || coins.length == 0)
			return -1;
		int[] r = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			// IntStream.of(coins).anyMatch(x -> x==val)
			if (contains(coins, i)) {
				r[i] = 1;
			} else {
				int min = Integer.MAX_VALUE;
				// pick up r[j] and r[i-j] and merge - keep track of the min sized list to reach the sum of i
				for (int j = i - 1; j >= (i + 1) / 2; j--) {
					if (r[j] > 0 && r[i - j] > 0) {
						// merge the two for a possible i sum
						min = Math.min(min, r[j] + r[i - j]);
					}
				}
				r[i] = min != Integer.MAX_VALUE ? min : r[i];
			}
		}
		System.out.println("time elapsed in ms:" + (System.currentTimeMillis() - start));
		return r[amount] == 0 ? -1 : r[amount];
	}

	private static boolean contains(int[] coins, int i) {
		for (int c : coins) {
			if (c == i)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// System.out.println(coinChange(new int[] { 1, 2, 5 }, 11));
		//System.out.println(coinChange(new int[] { 3, 7, 405, 436 }, 8839));
		System.out.println(coinChange(new int[] { 2 }, 3));
	}

}

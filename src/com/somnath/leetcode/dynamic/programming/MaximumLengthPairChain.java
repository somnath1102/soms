package com.somnath.leetcode.dynamic.programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// https://leetcode.com/problems/maximum-length-of-pair-chain/
public class MaximumLengthPairChain {

	public static int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
		Map<int[], Integer> m = new HashMap<>();
		for (int i = 0; i < pairs.length; i++) {
			for (int j = i+1; j < pairs.length; j++) {
				if (pairs[i][1] < pairs[j][0]) {
					System.out.println(Arrays.toString(pairs[i]) + ", setting in " + Arrays.toString(pairs[j]) + ":"
							+ Math.max(m.getOrDefault(pairs[j], 0), 1 + m.getOrDefault(pairs[i], 0)));
					m.put(pairs[j], Integer.valueOf(Math.max(m.getOrDefault(pairs[j], 0), 1 + m.getOrDefault(pairs[i], 0))));
				} else if (pairs[j][1] < pairs[i][0]) {
					System.out.println(Arrays.toString(pairs[j]) + ", setting in " + Arrays.toString(pairs[i]) + ":"
							+ Math.max(m.getOrDefault(pairs[i], 0), 1 + m.getOrDefault(pairs[j], 0)));
					m.put(pairs[i], Integer.valueOf(Math.max(m.getOrDefault(pairs[i], 0), 1 + m.getOrDefault(pairs[j], 0))));
				}
			}
		}

		int max = 0;
		for (Entry<int[], Integer> es : m.entrySet()) {
			System.out.println(Arrays.toString(es.getKey()) + ":" + es.getValue());
			max = Math.max(max, es.getValue());
		}
		return ++max;
	}

	public static void main(String[] args) {
		// cdbfae
		// int[][] x = { { 86, 88 }, { 4, 90 }, { 5, 84 }, { 90, 92 }, { 20, 80
		// }, { 16, 91 } };
		int[][] x = { { 9, 10 }, { 9, 10 }, { 4, 5 }, { -9, -3 }, { -9, 1 }, { 0, 3 }, { 6, 10 }, { -5, -4 }, { -7, -6 } };
		System.out.println(findLongestChain(x));
	}

}

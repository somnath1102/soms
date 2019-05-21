package com.somnath.leetcode.hashtable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKFrequent {

	public static List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			frequencies.put(nums[i], frequencies.get(nums[i]) == null ? 1 : 1 + frequencies.get(nums[i]));
		}
		PriorityQueue<Map.Entry<Integer, Integer>> p = new PriorityQueue<Map.Entry<Integer, Integer>>(k, (e1, e2) -> e1.getValue()
				.compareTo(e2.getValue()));
		for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
			if (p.size() == k) {
				if (p.peek().getValue() < entry.getValue()) {
					p.poll();
					p.offer(entry);
				}
			} else {
				p.offer(entry);
			}
		}
		return p.stream().map(x -> x.getKey()).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		// System.out.println(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 },
		// 2).stream().map(x -> x + "").collect(Collectors.joining(",")));
		System.out.println(topKFrequent(new int[] { 4, 1, 1, 4, 4, 1, 2, 2, 3, 4, 3, 3, 3, 3, 4, 4 }, 2).stream().map(x -> x + "")
				.collect(Collectors.joining(",")));
	}
}

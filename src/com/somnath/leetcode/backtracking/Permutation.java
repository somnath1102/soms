package com.somnath.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {

	public static List<List<Integer>> permute(int[] nums) {
		LinkedList<List<Integer>> resultQ = new LinkedList<List<Integer>>();
		resultQ.offer(new ArrayList<Integer>());
		for (int i = 0; i < nums.length; i++) {
			int size = resultQ.size();
			for (int j = 0; j < size; j++) {
				List<Integer> poll = resultQ.poll();
				for (int k = 0; k <= poll.size(); k++) {
					List<Integer> extended = new ArrayList<>(poll.size() + 1);
					extended.addAll(poll);
					extended.add(k, nums[i]);
					resultQ.offer(extended);
				}
			}
		}
		return resultQ;
	}

	public static void main(String[] args) {
		for (List<Integer> l : permute(new int[] { 1, 2, 3 })) {
			System.out.println(l.stream().map(x -> x + "").collect(Collectors.joining(",")));
		}
	}

}

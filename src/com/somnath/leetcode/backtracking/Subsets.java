package com.somnath.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Subsets {
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> numsList = new ArrayList<Integer>();
		for (Integer i : nums) {
			numsList.add(i);
		}
		List<Integer> empty = new ArrayList<Integer>();
		result.add(empty);
		findCombinations(empty, numsList, result);
		return result;
	}

	private static void findCombinations(List<Integer> curr, List<Integer> rem, List<List<Integer>> result) {
		for (int i = 0; i < rem.size(); i++) {
			List<Integer> currCLone = new ArrayList<>(curr.size() + 1);
			currCLone.addAll(curr);
			currCLone.add(rem.get(i));
			result.add(currCLone);
			findCombinations(currCLone, rem.subList(i + 1, rem.size()), result);
		}
	}

	public static void main(String[] args) {
		for (List<Integer> l : subsets(new int[] { 1, 2, 3 })) {
			System.out.println(l.stream().map(x -> x + "").collect(Collectors.joining(",")));
		}
	}

}

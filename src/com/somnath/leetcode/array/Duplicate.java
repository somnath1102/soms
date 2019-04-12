package com.somnath.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class Duplicate {
	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> x = new HashSet<>();
		for (int num : nums) {
			if (!x.add(num)) {
				//System.out.println(num);
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int x = args.length;
		System.out.println(containsDuplicate(new int[] { 1, 2, 13, 14, 9, 0, 13, 7, 788 }));
	}
}

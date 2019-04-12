package com.somnath.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection {

	public static int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> m1 = new HashMap<>();
		build(nums1, m1);
		Map<Integer, Integer> m2 = new HashMap<>();
		build(nums2, m2);
		Map<Integer, Integer> lessKeys = m1.size() < m2.size() ? m1 : m2;
		Map<Integer, Integer> moreKeys = m2 == lessKeys ? m1 : m2;
		List<Integer> output = new ArrayList<Integer>();
		for (int key : lessKeys.keySet()) {
			if(moreKeys.containsKey(key)) {
				int count = lessKeys.get(key) < moreKeys.get(key) ? lessKeys.get(key) : moreKeys.get(key);
				while(count-- > 0) {
					output.add(key);
				}
			}
		}
		int [] retArr = new int [output.size()];
		for (int i = 0; i < retArr.length; i++) {
			retArr[i] = output.get(i);
		}
		return retArr;
	}

	private static void build(int[] nums1, Map<Integer, Integer> m1) {
		for (int i : nums1) {
			if (m1.containsKey(i)) {
				m1.put(i, m1.get(i) + 1);
			}
			else {
				m1.put(i, 1);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersect(new int[] { 3, 6, 9, 4, 4, 13, 9, 8, 4 }, new int[] { 6, 5, 4, 9, 0, 1, 13 })));
	}

}

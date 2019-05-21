package com.somnath.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

// uses the sliding window technique - two pointers
public class LongestNonRepeatingSubstring {

	public static int lengthOfLongestSubstring(String s) {
		int i = 0, j = 0;
		int max = 0;
		Set<Character> set = new HashSet<>();
		while (j < s.length()) {
			if (set.contains(s.charAt(j))) {
				int k = i;
				while (s.charAt(k) != s.charAt(j)) {
					set.remove(s.charAt(k));
					k++;
				}
				i = ++k;
			} else {
				set.add(s.charAt(j));
				max = Math.max(max, set.size());
			}
			j++;
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abeecdee"));
	}

}

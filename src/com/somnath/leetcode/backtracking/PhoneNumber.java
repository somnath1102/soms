package com.somnath.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

// https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/793/
public class PhoneNumber {

	static Map<Character, List<Character>> m = new HashMap<>();
	static {
		m.put('2', Arrays.asList(new Character[] { 'a', 'b', 'c' }));
		m.put('3', Arrays.asList(new Character[] { 'd', 'e', 'f' }));
		m.put('4', Arrays.asList(new Character[] { 'g', 'h', 'i' }));
		m.put('5', Arrays.asList(new Character[] { 'j', 'k', 'l' }));
		m.put('6', Arrays.asList(new Character[] { 'm', 'n', 'o' }));
		m.put('7', Arrays.asList(new Character[] { 'p', 'q', 'r', 's' }));
		m.put('8', Arrays.asList(new Character[] { 't', 'u', 'v' }));
		m.put('9', Arrays.asList(new Character[] { 'w', 'x', 'y', 'z' }));
	}

	public static List<String> letterCombinations(String digits) {
		if(digits == null || digits.isEmpty())
			return new ArrayList<>();
		Queue<StringBuilder> partial = new LinkedList<>();
		partial.offer(new StringBuilder());
		Queue<List<Character>> pendingQ = new LinkedList<>();
		for (Character c : digits.toCharArray()) {
			pendingQ.offer(m.getOrDefault(c, new ArrayList<>()));
		}
		combine(partial, pendingQ);
		return partial.stream().map(sb -> sb.toString()).collect(Collectors.toList());
	}

	private static void combine(Queue<StringBuilder> partial, Queue<List<Character>> pendingQ) {
		if (!pendingQ.isEmpty()) {
			List<Character> firstPending = pendingQ.poll();
			int partialSize = partial.size();
			for (int i = 0; i < partialSize; i++) {
				StringBuilder sbPartial = partial.poll();
				for (Character pChar : firstPending) {
					StringBuilder partialCopy = new StringBuilder(sbPartial);
					partial.offer(partialCopy.append(pChar));
				}
			}
			combine(partial, pendingQ);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(letterCombinations("").stream().collect(Collectors.joining(",")));
	}
}

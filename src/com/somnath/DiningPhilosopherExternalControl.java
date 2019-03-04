package com.somnath;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class DiningPhilosopherExternalControl {
	static Set<String> eating = new HashSet<>();
	static Deque<String> thinkingQ = new LinkedList<>();
	static Map<String, Set<String>> exclusions = new HashMap<String, Set<String>>();

	static {
		eating.addAll(Arrays.asList("A", "C"));
		exclusions.put("A", new HashSet<String>(Arrays.asList("B", "E")));
		exclusions.put("B", new HashSet<String>(Arrays.asList("A", "C")));
		exclusions.put("C", new HashSet<String>(Arrays.asList("B", "D")));
		exclusions.put("D", new HashSet<String>(Arrays.asList("C", "E")));
		exclusions.put("E", new HashSet<String>(Arrays.asList("A", "D")));
		thinkingQ.addAll(Arrays.asList("B", "E", "D"));
	}

	public static void main(String[] args) {
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			System.out.println(eating);
			String stoppedEating = (String) eating.toArray()[random.nextInt(2)];
			eating.remove(stoppedEating);
			thinkingQ.addLast(stoppedEating);
			for (String nextPick : thinkingQ) {
				if (!exclusions.get((String) eating.toArray()[0]).contains(nextPick)) {
					eating.add(nextPick);
					thinkingQ.remove(nextPick);
					break;
				}
			}
		}
	}
}

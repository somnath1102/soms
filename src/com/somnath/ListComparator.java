package com.somnath;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ListComparator {

	static Set<List<Integer>> result = new TreeSet<List<Integer>>(new Comparator<List<Integer>>() {

		@Override
		public int compare(List<Integer> o1, List<Integer> o2) {
			if (o1 == o2)
				return 0;
			if (o1.size() > o2.size())
				return 1;
			else if (o1.size() < o2.size())
				return -1;
			else {
				int sum = 0;
				for (Integer integer : o1) {
					sum += integer;
				}
				for (Integer integer : o2) {
					sum -= integer;
				}
				if (sum != 0)
					return sum;
				Collections.sort(o1);
				Collections.sort(o2);
				for (int i = 0; i < o1.size(); i++) {
					if (o1.get(i) < o2.get(i))
						return -1;
					else if (o1.get(i) > o2.get(i))
						return 1;
				}
				return 0;
			}
		}
	});

	public static void main(String[] args) {
		result.add(Arrays.asList(new Integer[] { -4, 4, 0 }));
		result.add(Arrays.asList(new Integer[] { 1, 4, -5 }));
		result.add(Arrays.asList(new Integer[] { 1, -2, 1 }));
		result.add(Arrays.asList(new Integer[] { -4, 4, 0 }));

		for (List<Integer> subset : result) {
			System.out.println(subset.stream().map(x -> x + "").collect(Collectors.joining(",")));
		}
	}
}

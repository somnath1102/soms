package com.somnath.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);

		while (--rowIndex >= 0) {
			List<Integer> t = new ArrayList<>();
			t.add(1);
			for (int i = 1; i < l.size(); i++) {
				t.add(i, l.get(i - 1) + l.get(i));
			}
			t.add(1);
			l = t;
		}
		return l;
	}

	public static void main(String[] args) {
		for (Integer i : getRow(6)) {
			System.out.print(i + ",");
		}
	}
}

package com.somnath.leetcode.queueandstack;

import java.util.Arrays;

public class DailyTemps {

	public static int[] dailyTemperatures(int[] T) {
		for (int i = 0; i < T.length; i++) {
			for (int j = i; j < T.length; j++) {
				if(T[j] > T[i]) {
					T[i] = j-i;
					break;
				}
				if(j == T.length-1)
					T[i] = 0;
			}
		}
		return T;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(dailyTemperatures(new int [] {73, 74, 75, 71, 69, 72, 76, 73})));
	}

}

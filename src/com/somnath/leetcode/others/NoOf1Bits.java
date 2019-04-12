package com.somnath.leetcode.others;

public class NoOf1Bits {

	public static int hammingWeight(int n) {
		int hw = 0;
		while (n > 0) {
			hw += (n & 1);
			n >>= 1;
		}
		return hw;
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.parseInt(Integer.toBinaryString(-3), 2));
		System.out.println(Integer.toBinaryString(-3));
	}

}

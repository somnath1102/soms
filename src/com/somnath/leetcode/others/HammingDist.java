package com.somnath.leetcode.others;

public class HammingDist {

	public static int hammingDistance(int x, int y) {
		// xor the two numbers and find the number of set bits in the result
		int xor = x ^ y;
		int count = 0;
		while (xor > 0) {
			count += xor & 1;
			xor >>= 1;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 1));
	}

}

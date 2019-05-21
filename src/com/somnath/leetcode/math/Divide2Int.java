package com.somnath.leetcode.math;

public class Divide2Int {

	public static int divide(int dividend, int divisor) {
		int negCount = 0;
		if (dividend < 0) {
			dividend = -dividend;
			negCount++;
		}
		if (divisor < 0) {
			divisor = -divisor;
			negCount++;
		}
		if (dividend < divisor)
			return 0;
		int q = 0;
		int sum = divisor;
		while (dividend >= sum) {
			sum += divisor;
			q++;
		}
		return (negCount & 1) == 1 ? -q : q;
	}

	public static void main(String[] args) {
		System.out.println(divide(-2147483648, -1));
		System.out.println(-2147483648 / -1);
		System.out.println(Math.pow(2, 31) -1);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}

}

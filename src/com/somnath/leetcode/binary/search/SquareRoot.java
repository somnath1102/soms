package com.somnath.leetcode.binary.search;

public class SquareRoot {

	public static int mySqrt(int x) {
		 if (x < 2)
				return x;
			int upper = x;
			int lower = 0;
			int middle = -1;
			// to prevent overflow in big integer addition 
			while ((middle = (upper - lower) / 2 + lower) > lower) {
				middle = (upper + lower) / 2;
				System.out.println("middle:" + middle + ",upper:" + upper + ",lower:" + lower + ",x/mid:" + x/middle);
				if (middle == x/middle)
					return middle;
				if (middle > x/middle) {
					upper = middle;
				} else {
					lower = middle;
				}
			}
			System.out.println("MMmiddle:" + middle + ",upper:" + upper + ",lower:" + lower + ",x/mid:" + x/middle);
			return middle;
	}

	public static void main(String[] args) {
		System.out.println(mySqrt(1000));
	}

}

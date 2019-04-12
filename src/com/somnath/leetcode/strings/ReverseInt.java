package com.somnath.leetcode.strings;

public class ReverseInt {

	public static int reverse(int x) {
		int sign = 1;
		if (x < 0) {
			sign = -1;
			x *= -1;
		}
		
		long toReturn = 0 ;
		while (x > 0) {
			toReturn = toReturn * 10 + x%10;
			x /= 10;
		}
	
		if(toReturn == (int) toReturn)
			return (int) toReturn * sign;
		else 
			return 0;
	}

	public static void main(String[] args) {
		System.out.println(reverse(12345678));
	}

}

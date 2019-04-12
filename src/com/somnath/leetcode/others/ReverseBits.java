package com.somnath.leetcode.others;

// not working for extreme cases
public class ReverseBits {
	public static long reverseBits(long n) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while (n > 0) {
			sb.append(n&1);
			n >>=1;
			count++;
		}
		while(count++ < 32) {
			sb.append("0");
		}
		System.out.println(sb.toString());
		System.out.println(Long.parseLong(sb.toString(), 2));
		return Long.parseLong(sb.toString(), 2);
		//return Integer.parseInt(sb.toString(), 2);
	}
	
	public static void main(String[] args) {
		//System.out.println(reverseBits(Long.parseLong("11111111111111111111111111111101", 2)));
		System.out.println(Long.MAX_VALUE);
		String x = Long.MAX_VALUE + "";
		System.out.println(x.length());
		//2147483648 
	}

}

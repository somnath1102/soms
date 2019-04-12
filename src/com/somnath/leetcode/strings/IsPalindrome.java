package com.somnath.leetcode.strings;

public class IsPalindrome {

	public static boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if ((c - '0' >= 0 && c - '0' <= 9) || (c - 'a' >= 0 && 'z' - c >= 0) || (c - 'A' >= 0 && 'Z' - c >= 0))
				sb.append(c);
		}
		if (sb.toString().equalsIgnoreCase(sb.reverse().toString()))
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		
	}

}

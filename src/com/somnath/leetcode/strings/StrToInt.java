package com.somnath.leetcode.strings;

public class StrToInt {

	public static int myAtoi(String str) {
		char[] strArr = str.toCharArray();
		int sign = 0;
		long value = 0;
		for (char c : strArr) {
			if (c != ' ') {
				if (sign == 0) {
					// set sign
					sign = c == '-' ? -1 : c== '+' ? 1 : c - '0' < 0 || c - '0' > 10 ? 0 : 1;
					// not a sign or number - return
					if (sign == 0)
						return 0;
					if (c == '+' || c== '-') {
						// skip when explicit sign was set
						continue;
					}
				}
				if (c - '0' < 0 || c - '0' > 10)
					break;
				value = value * 10 + (c - '0');
				if (! (value == (int) value))
					break;
			} else if (sign != 0)
				break;
		}
		
		if (value == (int) value)
			return (int) value * sign;
		else if (sign < 1)
			return Integer.MIN_VALUE;
		else
			return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("-18446744073709551617"));
	}

}

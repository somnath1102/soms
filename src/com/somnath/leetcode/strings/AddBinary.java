package com.somnath.leetcode.strings;

public class AddBinary {
	public static String addBinary(String a, String b) {
		int bl = b.length() - 1;
		int al = a.length() - 1;
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		while (al >= 0 || bl >= 0) {
			int aInt = al < 0 ? 0 : a.charAt(al) - '0';
			int bInt = bl < 0 ? 0 : b.charAt(bl) - '0';
			sb.append(carry ^ aInt ^ bInt);
			carry = (aInt & bInt) | (carry & (aInt | bInt));
			al--;
			bl--;
		}
		if (carry > 0)
			sb.append(carry);
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		int x = "987".charAt(2) - '0';
		System.out.println(addBinary("0", "0"));
	}
}

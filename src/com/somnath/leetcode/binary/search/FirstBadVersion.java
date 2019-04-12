package com.somnath.leetcode.binary.search;

public class FirstBadVersion {

	public static int firstBadVersion(int n) {
		return firstBadVersion(1, n);
	}

	public static int firstBadVersion(int left, int right) {
		if (left == right)
			return left;
		if (right - left == 1)
			return isBadVersion(left) ? left : right;
		if (isBadVersion((right - left) / 2 + left)) {
			// go left
			return firstBadVersion(left, (right - left) / 2 + left);
		}
		// go right
		return firstBadVersion((right - left) / 2 + left + 1, right);
	}

	private static boolean isBadVersion(int i) {
		// TODO Auto-generated method stub
		return i >= 1702766719 ? true : false;
	}

	public static void main(String[] args) {
		System.out.println(firstBadVersion(2126753390));
	}
}

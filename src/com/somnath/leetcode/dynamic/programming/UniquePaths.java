package com.somnath.leetcode.dynamic.programming;

public class UniquePaths {
	public static int uniquePaths(int m, int n) {
		int dp[][] = new int[m][n];
		go(0, 0, dp);
		return dp[m - 1][n - 1];
	}

	public static int uniquePaths2(int m, int n) {
		Integer[][] map = new Integer[m][n];
		for (int i = 0; i < m; i++) {
			map[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			map[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				map[i][j] = map[i - 1][j] + map[i][j - 1];
			}
		}
		return map[m - 1][n - 1];
	}

	private static void go(int i, int j, int[][] dp) {
		if (i == dp.length || j == dp[0].length)
			return;
		// System.out.println(i+":"+j);
		dp[i][j] += 1;
		if ((i + 1) == dp.length && (j + 1) == dp[0].length)
			return;
		go(i + 1, j, dp);// go right
		go(i, j + 1, dp);// go down
	}

	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		 System.out.println(uniquePaths(23, 12));
		//System.out.println(uniquePaths(3, 2));
		System.out.println("Time(ms) : " + (System.currentTimeMillis() - s));
		long s2 = System.currentTimeMillis();
		 System.out.println(uniquePaths2(23, 12));
		//System.out.println(uniquePaths(3, 2));
		System.out.println("Time(ms) : " + (System.currentTimeMillis() - s2));
	}
}

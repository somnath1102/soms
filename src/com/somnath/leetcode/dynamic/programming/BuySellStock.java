package com.somnath.leetcode.dynamic.programming;

public class BuySellStock {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		// make 1 pass to see if descending - then return 0
		boolean descending = true;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i] < prices[i + 1]) {
				descending = false;
				break;
			}
		}
		if (descending)
			return 0;

		int[] profits = new int[prices.length];
		profits[0] = 0; // edge case
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			profits[i] = profits[i - 1] > 0 ? prices[i] - prices[i - 1] + profits[i - 1] : prices[i] - prices[i - 1];
			maxProfit = profits[i] > maxProfit ? profits[i] : maxProfit;
		}
		return maxProfit;
	}
}

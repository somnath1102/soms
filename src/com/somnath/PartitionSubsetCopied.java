package com.somnath;

import java.util.Arrays;

//Prob: Given a non-empty array containing only positive integers, 
//find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
// Solution Source : below is picked from leetcode solution at
// https://leetcode.com/problems/partition-equal-subset-sum/discuss/90592/01-knapsack-detailed-explanation
public class PartitionSubsetCopied {

	// sum = 58 {18,3,7,1}{16,4,9} - are the 2 partitions - see that this
	// reduces it to a subset sum problem where we are looking for
	// s subset which sums to arraysum/2
	public static boolean canPartition(int[] nums) {
		int sum = 0;

		for (int num : nums) {
			sum += num;
		}
		// sum is odd then cant have 2 equal partitions
		if ((sum & 1) == 1) {
			return false;
		}
		sum /= 2;

		boolean[] dp = new boolean[sum + 1];
		Arrays.fill(dp, false);
		dp[0] = true;

		for (int num : nums) {
			for (int i = sum; i > 0; i--) {
				if (i >= num) {
					dp[i] = dp[i] || dp[i - num];
				}
				System.out.println(num + "::" + Arrays.toString(dp));
			}
		}

		return dp[sum];
	}

	public static void main(String[] args) {
		System.out.println(canPartition(new int[] { 1, 7, 3, 5, 2 }));
		// sum/2 = 9 {1,3,5}{7,2}
		//System.out.println(canPartition(new int[] { 1, 4, 7, 18, 9, 16, 3,-3,2 }));
		// sum = 58 {18,3,7,1}{16,4,9} -3 and 2 pending makes it false
		
	}
}

package com.somnath.leetcode.array;

import java.util.Arrays;

public class MoveZeroes {

	public static void moveZeroes(int[] nums) {
		int i = 0, j = 0;
		while (i < nums.length) {
			if (nums[i] == 0) {
				j = j==0 ? i+1 : j;
				while (j < nums.length) {
					if (nums[j] != 0) {
						int temp = nums[i];
						nums[i] = nums[j];
						nums[j] = temp;
						break;
					}
					j++;
				}
			}
			i++;
		}
	}

	public static void main(String[] args) {
		// int[] nums = new int[] { 1, 0, 0, 0, 3, 12, 0, 7, 9, 0, 15, 16, 17, 0
		// };
		int[] nums = new int[] { 4, 2, 4, 0, 0, 3, 0, 5, 1, 0 };
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
}

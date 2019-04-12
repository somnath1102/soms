package com.somnath.leetcode.array;

import java.util.Arrays;

public class RemoveDups {
	
	public static void main(String[] args) {
		int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}
	
	public static int removeDuplicates(int[] nums) {
        int i = 0 ,j = 1;
        while(j < nums.length) {
            if(nums[j] > nums[i]){
                i++;
                nums[i] = nums[j];
                j += 1;
            } else {
                j++;
            }
        }
        return i + 1;
    }

}

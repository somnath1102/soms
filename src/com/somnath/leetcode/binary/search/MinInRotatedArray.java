package com.somnath.leetcode.binary.search;

public class MinInRotatedArray {
	
	public static int findMin(int[] nums) {
        return findMin(nums,0,nums.length-1);
    }
    
    
    public static int findMin(int[] nums, int left, int right) {
        if(left > right)
            return -1;
        if(left == right)
            return nums[left];
        if(right-left ==1) {
            return nums[left] < nums[right] ? nums[left] : nums[right];
        }
        int mid = (right-left)/2 + left;
        if(nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1])
            return nums[mid];
        else if(nums[mid] < nums[left]) {
            // go left
            return findMin(nums,left,mid);
        } else if(nums[left] > nums[right]){
            // go right
            return findMin(nums,mid+1,right);
        } else {
             // go left
            return findMin(nums,left,mid);
        }
             
    }
    
    public static void main(String[] args) {
		System.out.println(findMin(new int[] {4,5,6,7,0,1,2}));
	}

}

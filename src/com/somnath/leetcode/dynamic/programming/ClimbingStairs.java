package com.somnath.leetcode.dynamic.programming;

public class ClimbingStairs {

	public static int climbStairs(int n) {
		// is a fibonacci - 1,2,3,5,8,13,
		// 1-> [1] ; 2-> [1,1],[2], 3->[1,2],[1,1,1],[2,1] - for n - add 1 to
		// all subsets of n-1 and 2 to subsets of n-2
		int first = 1, next = 2;
		if(n==1)
            return first;
        if(n==2)
            return next;
		for (int i = 2; i < n; i++) {
			next += first;
			first = next - first;
		}
		return next;
	}

	public static void main(String[] args) {
		// System.currentTimeMillis()
		System.out.println(climbStairs(5)); 
		//433494437
		//165580141
		//267914296
	}

}

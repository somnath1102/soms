package com.somnath.leetcode.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Shuffle {

	private final int[] nums;
	private final List<List<Integer>> permutations = new ArrayList<>();
	private final Random r = new Random();

	public Shuffle(int[] nums) {
		this.nums = nums.clone();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums.clone();
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		if (nums == null || nums.length == 0)
			return nums;
		if (permutations.size() == 0) {
			permutate();
		}
		List<Integer> retList = permutations.get(r.nextInt(permSize(nums)));
		int[] retArr = new int[retList.size()];
		for (int i = 0; i < retArr.length; i++) {
			retArr[i] = retList.get(i);
		}
		return retArr;
	}

	private int permSize(int[] nums) {
		int result = 1;
		for (int i = 1; i <= nums.length; i++) {
			result *= i;
		}
		return result;
	}

	private void permutate() {
		if (nums == null || nums.length == 0)
			return;
		build(new ArrayList<Integer>(), 0);
	}

	private void build(List<Integer> current, int numsIdx) {
		for (int j = 0; j <= current.size(); j++) {
			List<Integer> currAppended = new ArrayList<>(current);
			currAppended.add(j, nums[numsIdx]);
			if (numsIdx == nums.length - 1) {
				permutations.add(currAppended);
			} else {
				build(currAppended, numsIdx + 1);
			}
		}
	}

	private void permutate2() {
		if (nums == null || nums.length == 0)
			return;
		List<Integer> numsList = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			numsList.add(nums[i]);
		}
		for (int i = 0; i < nums.length; i++) {
			ArrayList<Integer> perm = new ArrayList<>(numsList);
			perm.remove(nums[i]);
			for (int j = i + 1; j <= nums.length; j++) {

			}
		}
	}

	public static void main(String[] args) {
		Shuffle obj = new Shuffle(new int[] { 1, 2, 3, 4 });
		int[] param_1 = obj.reset();
		int[] param_2 = obj.shuffle();
		System.exit(0);
		List<Integer> any = new ArrayList<>();
		any.add(2);
		any.add(1);
		System.out.println(any.stream().map(Object::toString).collect(Collectors.joining(",")));
		any.add(2, 3);
		System.out.println(any.stream().map(Object::toString).collect(Collectors.joining(",")));
	}

}

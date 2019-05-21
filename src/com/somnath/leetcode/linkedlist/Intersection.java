package com.somnath.leetcode.linkedlist;

public class Intersection {

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode curr = headA;
		int maxA = Integer.MIN_VALUE;
		while(curr != null) {
			maxA = Math.max(maxA, curr.val);
			curr = curr.next;
		}
		curr = headB;
		while(curr != null) {
			curr.val = maxA+1;
			curr = curr.next;
		}
		curr = headA;
		while(curr.val <= maxA) {
			curr = curr.next;
		}
		return curr;
	}
	
	public static void main(String[] args) {
	}

}

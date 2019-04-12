package com.somnath.leetcode.linkedlist;

// O(n) and space O(1)
public class PalindromeBetter {
	public static boolean isPalindrome(ListNode head) {
		ListNode first = head;
		int size = 0;
		while (first != null) {
			size++;
			first = first.next;
		}
		// reverse the last half and compare with the first half
		int idxOf2ndHalf = size % 2 == 0 ? size / 2 + 1 : size / 2 + 2;
		first = head;
		while (--idxOf2ndHalf > 0) {
			first = first.next;
		}
		ListNode next = first.next;
		first.next = null;
		first = reverse(first, next);
		while (first != null && first.val == head.val) {
			first = first.next;
			head = head.next;
		}
		if (first == null)
			return true;
		return false;
	}

	private static ListNode reverse(ListNode prev, ListNode next) {
		if (next == null)
			return prev;
		ListNode temp = next.next;
		next.next = prev;
		return reverse(next, temp);

	}
	
	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		ListNode curr = root;
		curr.next = new ListNode(1);
		curr = curr.next;
//		curr.next = new ListNode(7);
//		curr = curr.next;
//		curr.next = new ListNode(9);
//		curr = curr.next;
//		curr.next = new ListNode(9);
//		curr = curr.next;
//		curr.next = new ListNode(9);
//		curr = curr.next;
//		curr.next = new ListNode(7);
//		curr = curr.next;
//		curr.next = new ListNode(4);
//		curr = curr.next;
//		curr.next = new ListNode(1);

		System.out.println(isPalindrome(root));
	}
}

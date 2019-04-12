package com.somnath.leetcode.linkedlist;

public class Reverse {

	public ListNode reverseList(ListNode head) {
		ListNode next = head.next;
		head.next = null;
		return link(next, head);
	}

	public ListNode link(ListNode next, ListNode prev) {
		if (next == null)
			return prev;
		ListNode temp = next.next;
		next.next = prev;
		return link(temp, next);
	}



	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);

		Reverse r = new Reverse();
		ListNode x = r.reverseList(root);
		System.out.println("dfdwf");
	}

}

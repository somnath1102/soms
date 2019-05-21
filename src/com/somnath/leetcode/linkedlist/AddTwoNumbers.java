package com.somnath.leetcode.linkedlist;

public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode l1Copy = l1;
		int carry = 0;
		ListNode prev = null;
		while (l1 != null && l2 != null) {
			l1.val = l1.val + l2.val + carry;
			carry = l1.val / 10;
			l1.val %= 10;
			prev = l1;
			l1 = l1.next;
			l2 = l2.next;
		}
		if (l1 == null && l2 == null) {
			if (carry > 0)
				prev.next = new ListNode(carry);
		} else {
			ListNode pending = (l1 == null) ? l2 : l1;
			prev.next = pending;
			while (pending != null) {
				pending.val += carry;
				carry = pending.val / 10;
				pending.val %= 10;
				prev = pending;
				pending = pending.next;
			}
			if (carry > 0)
				prev.next = new ListNode(carry);
		}
		return l1Copy;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
		l1.next = new ListNode(4);
		ListNode l2 = new ListNode(7);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(9);
		l2.next.next.next.next = new ListNode(9);
		ListNode r = addTwoNumbers(l1, l2);
		while(r != null) {
			System.out.print(r.val);
			r = r.next;
		}
	}
}

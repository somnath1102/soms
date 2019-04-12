package com.somnath.leetcode.linkedlist;

public class MergeSortedList {

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode m = new ListNode(-1);
		ListNode mRoot = m;
		while (true) {
			if (l1 == null) {
				m.next = l2;
				break;
			}
			if (l2 == null) {
				m.next = l1;
				break;
			}
			if (l1.val > l2.val) {
				m.next = l2;
				l2 = l2.next;
			} else {
				m.next = l1;
				l1 = l1.next;
			}
			m = m.next;
		}
		return mRoot.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		ListNode m = mergeTwoLists(l1, l2);
		System.out.println(m.val);
	}

}

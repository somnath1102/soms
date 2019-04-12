package com.somnath.leetcode.linkedlist;

public class Cycle {

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode slow = head, fast = head;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
			fast = fast == null ? null : fast.next;
			if (slow == fast)
				return true;
		}
		return false;
	}

}

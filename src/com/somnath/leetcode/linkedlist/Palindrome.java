package com.somnath.leetcode.linkedlist;

import java.util.Stack;

public class Palindrome {

	public static boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;
		Stack<ListNode> reverse = new Stack<>();
		ListNode r = head;
		reverse.push(r);
		while (r.next != null) {
			reverse.push(r.next);
			r = r.next;
		}

		while (!reverse.isEmpty() && reverse.pop().val == head.val) {
			head = head.next;
		}
		if (head != null)
			return false;
		return true;
	}

	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		ListNode curr = root;
		curr.next = new ListNode(2);
		curr = curr.next;
		curr.next = new ListNode(4);
		curr = curr.next;
		curr.next = new ListNode(2);
		curr = curr.next;
		curr.next = new ListNode(3);
		curr = curr.next;
		curr.next = new ListNode(2);
		curr = curr.next;
		curr.next = new ListNode(4);
		curr = curr.next;
		curr.next = new ListNode(2);
		curr = curr.next;
		curr.next = new ListNode(1);

		System.out.println(isPalindrome(root));
	}

}

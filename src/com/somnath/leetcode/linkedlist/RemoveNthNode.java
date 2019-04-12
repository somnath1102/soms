package com.somnath.leetcode.linkedlist;

public class RemoveNthNode {

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode first = new ListNode(-1), second = head;
		first.next = head;
		while (n-- > 0) {
			second = second.next;
		}
		while (second != null) {
			first = first.next;
			second = second.next;
		}
		if(first.next == head)
			return head.next;
		first.next = first.next.next;
		return head;
	}

	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
//		root.next.next = new ListNode(3);
//		root.next.next.next = new ListNode(4);
//		root.next.next.next.next = new ListNode(5);
		ListNode result = removeNthFromEnd(root, 2);
		while(result != null) {
			System.out.print(result.val + ",");
			result = result.next;
		}
	}

}

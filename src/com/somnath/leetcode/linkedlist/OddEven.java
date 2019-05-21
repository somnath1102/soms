package com.somnath.leetcode.linkedlist;

public class OddEven {

	public static ListNode oddEvenList(ListNode head) {
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;
		while (odd.next != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}

	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		ListNode head = l;
//		l.next = new ListNode(2);
//		l = l.next;
//		l.next = new ListNode(3);
//		l = l.next;
//		l.next = new ListNode(4);
//		l = l.next;
//		l.next = new ListNode(5);
		System.out.println(oddEvenList(head));
		while (head != null) {
			System.out.print(head.val + ",");
			head = head.next;
		}
	}

}

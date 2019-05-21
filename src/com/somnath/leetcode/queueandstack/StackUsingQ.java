package com.somnath.leetcode.queueandstack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQ {

	Queue<Integer> q;

	/** Initialize your data structure here. */
	public StackUsingQ() {
		q = new LinkedList<Integer>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		q.offer(x);
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		for (int i = 1; i < q.size(); i++) {
			q.offer(q.poll());
		}
		return q.poll();
	}

	/** Get the top element. */
	public int top() {
		int x = pop();
		push(x);
		return x;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return q.isEmpty();
	}

}

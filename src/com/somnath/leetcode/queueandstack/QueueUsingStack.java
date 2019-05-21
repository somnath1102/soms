package com.somnath.leetcode.queueandstack;

import java.util.Stack;

public class QueueUsingStack {

	Stack<Integer> push;
	Stack<Integer> pop;

	public QueueUsingStack() {
		push = new Stack<>();
		pop = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		if (!pop.isEmpty()) {
			while (!pop.isEmpty()) {
				push.push(pop.pop());
			}
		}
		push.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (!push.isEmpty()) {
			while (!push.isEmpty()) {
				pop.push(push.pop());
			}
		}
		return pop.pop();
	}

	/** Get the front element. */
	public int peek() {
		if (!push.isEmpty()) {
			while (!push.isEmpty()) {
				pop.push(push.pop());
			}
		}
		return pop.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return push.isEmpty() && pop.isEmpty();
	}
}

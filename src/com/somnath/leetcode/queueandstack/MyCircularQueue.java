package com.somnath.leetcode.queueandstack;

public class MyCircularQueue {

	int[] queue;
	int headIdx = -1;
	int tailIdx = -1;

	/** Initialize your data structure here. Set the size of the queue to be k. */
	public MyCircularQueue(int k) {
		queue = new int[k];
	}

	/**
	 * Insert an element into the circular queue. Return true if the operation
	 * is successful.
	 */
	public boolean enQueue(int value) {
		if (!isFull()) {
			if (isEmpty()) {
				headIdx = tailIdx = 0;
			} else {
				tailIdx = (tailIdx + 1) % queue.length;
			}
			queue[tailIdx] = value;
			return true;
		}
		return false;
	}

	/**
	 * Delete an element from the circular queue. Return true if the operation
	 * is successful.
	 */
	public boolean deQueue() {
		if (!isEmpty()) {
			if (headIdx == tailIdx) {
				headIdx = tailIdx = -1;
			} else {
				headIdx = (headIdx + 1) % queue.length;
			}
			return true;
		}
		return false;

	}

	/** Get the front item from the queue. */
	public int Front() {
		return isEmpty() ? -1 : queue[headIdx];

	}

	/** Get the last item from the queue. */
	public int Rear() {
		return isEmpty() ? -1 : queue[tailIdx];
	}

	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		return headIdx == -1;

	}

	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		if (headIdx > tailIdx) {
			return headIdx - tailIdx == 1;
		}
		return tailIdx - headIdx == queue.length - 1;
	}

}

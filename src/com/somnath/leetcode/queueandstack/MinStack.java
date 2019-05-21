package com.somnath.leetcode.queueandstack;

import java.util.Stack;

class NextMinAware {
	int val;

	NextMinAware(int val) {
		this.val = val;
	}

	NextMinAware next;
}

class MinStack {
	Stack<NextMinAware> s;
	NextMinAware min = new NextMinAware(Integer.MAX_VALUE);

	public MinStack() {
		s = new Stack<NextMinAware>();
	}

	public void push(int x) {
		NextMinAware nx = new NextMinAware(x);
		if (x <= min.val) {
			nx.next = min;
			min = nx;
		} 
		s.push(nx);
	}

	public void pop() {
		NextMinAware x = s.pop();
		if (x == min) {
			min = min.next;
		} 
	}
	
	public int top() {
		return s.peek().val;

	}

	public int getMin() {
		return min.val;
	}

	public static void main(String[] args) {
		MinStack m = new MinStack();
		m.push(2147483646);
		m.push(2147483646);
		m.push(2147483647);
		System.out.println(m.top());
		m.pop();
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.getMin());
		m.pop();
		m.push(2147483647);
		System.out.println(m.top());
		System.out.println(m.getMin());
		m.push(-2147483648);
		System.out.println(m.top());
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.getMin());
	}

}



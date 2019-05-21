package com.somnath.leetcode.queueandstack;

import java.util.Map;
import java.util.Stack;

public class RPN {
	static Map<String, Operation> operators;

	static {
		operators.put("+", (y, x) -> x + y);
		operators.put("-", (y, x) -> x - y);
		operators.put("/", (y, x) -> x / y);
		operators.put("*", (y, x) -> x * y);
	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			if (operators.containsKey(tokens[i])) {
				s.push(operators.get(tokens[i]).operate(s.pop(), s.pop()));
			} else {
				s.push(Integer.valueOf(tokens[i]));
			}
		}
		return s.peek();
	}
}

@FunctionalInterface
interface Operation {
	int operate(int o1, int o2);
}

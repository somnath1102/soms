package com.somnath.java8;

import java.util.stream.Stream;

public class FunctionCall {
	
	public static void main(String[] args) {
		// since there is a lambda requirement with an api of one argument we can substitute it with an other function
		// which takes one argumnent
		Stream.of(1,2,3,4).forEach(FunctionCall::dosomething);
	}
	
	static <T>  int dosomething(T any) {
		return 5;
	}

}

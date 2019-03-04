package com.somnath;

public class SimpleFibonacci {
	public static void main(String[] args) {
		int first= 0 , next =1;
		System.out.println(first);
		System.out.println(next);
		while (true) {
			next = next + first;
			first = next - first;
			System.out.println(next);
			if(next > 1000)
				break;
		}
	}

}

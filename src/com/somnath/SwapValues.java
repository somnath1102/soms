package com.somnath;

public class SwapValues {

	public static void main(String[] args) {
		Holder h1 = new Holder("one");
		Holder h2 = new Holder("two");
		System.out.println(h1.val + " -----" + h2.val);
		swap(h1, h2);
		System.out.println(h1.val + " -----" + h2.val);
		
	}

	private static void swap(Holder h1, Holder h2) {
		String temp = h1.val;
		h1.val = h2.val;
		h2.val = temp;
//		h1 = new Holder("three");
//		h2 = new Holder("four");
	}

}

class Holder {
	String val;
	public Holder(String val) {
		this.val = val;
	}
}

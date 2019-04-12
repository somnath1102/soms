package com.somnath;

import java.util.ArrayList;
import java.util.List;

public class ArrayListResize {
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		l.add("1");
		l.add("2");
		l.add("3");
		l.add("4");
		System.out.println(l.indexOf("4"));
		l.remove("3");
		System.out.println(l.indexOf("4"));
	}

}

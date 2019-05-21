package com.somnath.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Collector {
	
	public static void main(String[] args) {
		List<Integer> iValues = new ArrayList<>();
		iValues.add(22);
		iValues.add(33);
		iValues.add(44);
		iValues.add(55);
		
		String collect = iValues.stream().map(p -> p.toString()).collect(Collectors.joining(System.lineSeparator()));
		
		System.out.println(collect);
		
	}

}

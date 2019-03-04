package com.somnath;

import java.util.Arrays;
import java.util.List;

public class LambdaUsage {
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("anna", "gogo", "banazzz", "caca", "kaka", "cara", "zica", "tanga");
		System.out.println(strings.stream().filter(x -> x.indexOf('k') == -1).map(x -> x.toUpperCase()).sorted((x, y) -> {
			int xval = 0;
			for (char c : x.toCharArray()) {
				xval += c;
			}
			
			int yval = 0;
			for (char c : y.toCharArray()) {
				yval += c;
			};
			
			return xval - yval;
			
		}).reduce((a, b) -> a + " $" + b).get());
	}
}

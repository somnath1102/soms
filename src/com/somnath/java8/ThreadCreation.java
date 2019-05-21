package com.somnath.java8;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreadCreation {
	
	void create() {
		Stream.iterate(0, n -> n+1).map(Thread::new).limit(10).collect(Collectors.toList());
	}

}

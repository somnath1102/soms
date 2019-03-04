package com.somnath;

import java.util.ArrayList;
import java.util.List;

public class Multiargs {
	
	  public static void main(String[] args) {
	        List<String> strList = new ArrayList<>();
	        strList.add("one");
	        strList.add("two");
	        print("first", strList.toArray());
	    }

	    static void print(String initial, Object... args) {
	        StringBuilder sb = new StringBuilder();
	        sb.append(initial);
	        for (Object arg : args ) {
	            sb.append("," + arg.toString() );
	        }
	        System.out.println(sb.toString());
	    }

}

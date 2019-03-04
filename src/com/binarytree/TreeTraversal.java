package com.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {
	
	public static void main(String[] args) {
		buildTree(10,15,30, 3,6,null,2,5,null, null, null, 9,8);
	}

	private static void buildTree(Integer ...values) {
		Queue<Integer> queue = null;
		for (Integer value : values) {
			if(queue == null) {
				queue = new LinkedList<Integer>();
				queue.add(value);
			}
				
			queue.add(e)
		}
	}

}

class Node {
	private Integer value;

	private Node left;
	private Node right;
	
	public Node(Integer value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public Node(Integer value) {
		this(value, null, null);
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}

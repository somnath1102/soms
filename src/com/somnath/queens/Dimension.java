package com.somnath.queens;


public enum Dimension {
	One(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8);
	private int value;

	private Dimension(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public Dimension findByValue(int value) {
		for (Dimension dimension : Dimension.values()) {
			if (dimension.value == value) {
				return dimension;
			}
		}
		return null;
	}

	public Dimension increment() {
		return findByValue(getValue()+1);
	}
}

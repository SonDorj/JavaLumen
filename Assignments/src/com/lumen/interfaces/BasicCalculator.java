package com.lumen.interfaces;

public class BasicCalculator implements Calculator {

	@Override
	public int add(int x, int y) {
		return x+y;
	}

	@Override
	public int product(int x, int y) {
		return x*y;
	}

}

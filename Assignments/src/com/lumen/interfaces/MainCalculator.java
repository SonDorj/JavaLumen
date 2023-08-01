package com.lumen.interfaces;

public class MainCalculator {
	public static void main(String[] args) {
		Calculator calculator = new BasicCalculator();
		System.out.println(calculator.add(12, 12));
		System.out.println(calculator.product(12, 12));

		Scientific scientificCalculator= new ScientificCalculator();
		System.out.println(scientificCalculator.square(3));
		System.out.println(scientificCalculator.cube(3));
		System.out.println(scientificCalculator.add(13, 12));
		System.out.println(scientificCalculator.product(10, 12));
	}
}

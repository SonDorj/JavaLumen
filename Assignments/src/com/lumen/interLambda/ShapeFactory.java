package com.lumen.interLambda;

public class ShapeFactory {
	public void printArea(Shape shape, double x, double y) {
		System.out.println("Printing Area...");
		shape.calcArea((int)x, (int)y);
		System.out.println("Done!");
	}
}

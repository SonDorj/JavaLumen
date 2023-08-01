package com.lumen.interLambda;

public class ShapeMain {
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		shapeFactory.printArea((double x,double y)->System.out.println("Rectangle Area is : "+(x*y)), 3d, 2d);
		shapeFactory.printArea((double x,double y)->System.out.println("Triangel Area is : "+0.5*(x*y)), 2d, 3d);
	}
}

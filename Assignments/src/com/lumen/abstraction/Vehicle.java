package com.lumen.abstraction;

public abstract class Vehicle {
	String model;
	String brand;
	double price;

	public Vehicle(String model, String brand, double price) {
		this.model = model;
		this.brand = brand;
		this.price = price;
	}

	void printDetails() {
		System.out.println(model+" "+brand+" "+price);
	}

	abstract void showMilage();
	abstract void showType();
}

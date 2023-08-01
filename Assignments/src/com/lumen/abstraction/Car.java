package com.lumen.abstraction;

public class Car extends Vehicle {
	String[] Accessories;


	public Car(String model, String brand, double price, String... accessories) {
		super(model, brand, price);
		Accessories = accessories;
	}

	@Override
	void showMilage() {
		System.out.println("milage is : 20km/l");
	}

	@Override
	void showType() {
		System.out.println("type is : "+((model.split(" ")[1]).isBlank()?(model.split(" ")[1]):model.split(" ")[1]));
	}
}

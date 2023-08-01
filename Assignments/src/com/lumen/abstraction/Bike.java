package com.lumen.abstraction;

public class Bike extends Vehicle {

	public Bike(String model, String brand, double price) {
		super(model, brand, price);
	}

	@Override
	void showMilage() {
		System.out.println("milage is : 80km/l");
	}

	@Override
	void showType() {
		if(price>500_000)
			System.out.println("Super car");
		else
			System.out.println("Normal car");
	}
	void engineType() {
		System.out.println("engine type is v"+model.split(" ")[1]);
	}

}

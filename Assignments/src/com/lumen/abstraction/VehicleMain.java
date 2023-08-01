package com.lumen.abstraction;

public class VehicleMain {
	public static void main(String[] args) {
		Vehicle ride= new Car("nissan Altima","nissan",100_000d,"4 rear_view mirrors","convertible");
		ride.printDetails();
		ride.showMilage();
		ride.showType();

		Car myCar = (Car)ride;
		System.out.println("features: ");
		for(String accessory: myCar.Accessories) {
			System.out.print(accessory+", ");
		}
		System.out.println();

		ride= new Bike("X-tec 8","TVS",60_000d);
		ride.printDetails();
		ride.showMilage();
		ride.showType();

		Bike myBike = (Bike)ride;
		myBike.engineType();
	}
}

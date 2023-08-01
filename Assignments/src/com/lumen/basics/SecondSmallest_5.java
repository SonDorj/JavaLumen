package com.lumen.basics;

public class SecondSmallest_5 {
	int[] array;

	SecondSmallest_5(int[] array) {
		this.array = array;
	}

	void print() {
		for (int number : array) {
			System.out.print(number + " ");
		}
		System.out.println();
	}

	int secondSmallest() {
		int smallest = 2147483647;
		int secondSmallest = 2147483647;
		for (int number : array) {
			if (number < secondSmallest)
				if (number < smallest) {
					secondSmallest = smallest;
					smallest = number;
				}
				else
					secondSmallest = number;
		}
		return secondSmallest;
	}
	public static void main(String[] args) {
		SecondSmallest_5 intArray=new SecondSmallest_5(new int[] {1,3,2,14,5,5});
		intArray.print();
		System.out.println("Second smallest is: "+intArray.secondSmallest());
	}
}

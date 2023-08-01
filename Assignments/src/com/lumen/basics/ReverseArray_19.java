package com.lumen.basics;

public class ReverseArray_19 {
	int array[];
	int reverseArray[];

	public ReverseArray_19(int[] array) {
		this.array = array;
		reverseArray = new int[array.length];
		for (int j = 0; j < array.length; j++) {
			reverseArray[j] = array[array.length - (j + 1)];
		}
	}

	void print() {
		for (int number : array) {
			System.out.print(number + " ");
		}
		System.out.println();
	}

	void printReverse() {
		for (int number : reverseArray) {
			System.out.print(number + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ReverseArray_19 intArray = new ReverseArray_19(new int[] { 1, 2, 3, 4, 5 });
		intArray.print();
		System.out.print("Reverse : ");
		intArray.printReverse();
	}

}

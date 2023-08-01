package com.lumen.basics;

public class SecondGreatest_6 {
	int[] array;
	SecondGreatest_6(int[] array) {
		this.array = array;
	}

	void print() {
		for (int number : array) {
			System.out.print(number + " ");
		}
		System.out.println();
	}

	int secondGreatest() {
		int largest = -2147483648;
		int secondLargest = -2147483648;
		for (int number : array) {
			if (number > secondLargest)
				if (number > largest) {
					secondLargest = largest;
					largest = number;
				}
				else
					secondLargest = number;
		}
		return secondLargest;
	}
	public static void main(String[] args) {
		SecondGreatest_6 intArray=new SecondGreatest_6(new int[] {1,7,14,5,5});
		intArray.print();
		System.out.println("Second greatest is: "+intArray.secondGreatest());
	}
}

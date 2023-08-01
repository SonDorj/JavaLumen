package com.lumen.basics;

public class CountDuplicate_17 {
	int array[];

	public CountDuplicate_17(int[] array) {
		this.array = array;
	}

	void print() {
		for (int number : array) {
			System.out.print(number + " ");
		}
		System.out.println();
	}

	int countDuplicate() {
		int cnt = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					cnt++;
					break;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		CountDuplicate_17 intArray = new CountDuplicate_17(new int[] { 1, 7, 14, 5, 5 });
		intArray.print();
		System.out.println("Duplicate elements in the array: " + intArray.countDuplicate());
	}

}

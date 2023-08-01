package com.lumen.basics;

public class SortArray_20 {
	int[] array;
	int[] sortedArray;
	public SortArray_20(int[] array) {
		this.array = array;
		sortedArray=sortArray();
	}
	void print() {
		for (int number : array) {
			System.out.print(number + " ");
		}
		System.out.println();
	}
	void printSorted() {
		for(int number:sortedArray) {
			System.out.print(number+" ");
		}
	}
	int[] sortArray() {
		int sorted[]=array;
		int temp;
		for (int i = 0; i < sorted.length; i++) {
			for (int j = i; j < sorted.length; j++) {
				if(sorted[i]>sorted[j]) {
					temp=sorted[i];
					sorted[i]=sorted[j];
					sorted[j]=temp;
				}
			}
		}
		return sorted;
	}
	public static void main(String[] args) {
		SortArray_20 intArray=new SortArray_20(new int[] {1,7,14,5,5});
		intArray.print();
		System.out.println("Sorted array : ");
		intArray.printSorted();
	}

}

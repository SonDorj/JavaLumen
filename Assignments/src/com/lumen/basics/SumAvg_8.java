package com.lumen.basics;

public class SumAvg_8 {
	int[] array;
	public SumAvg_8(int[] array) {
		this.array = array;
	}
	void print() {
		for (int number : array) {
			System.out.print(number + " ");
		}
		System.out.println();
	}
	int SumArray() {
		int sum=0;
		for(int number: array) {
			sum+=number;
		}
		return sum;
	}
	double AvgArray() {
		return (double)SumArray()/(double)array.length;
	}
	public static void main(String[] args) {
		SumAvg_8 intArray=new SumAvg_8(new int[] {1,7,14,5,5});
		intArray.print();
		System.out.println("Sum: "+intArray.SumArray()+" Average: "+intArray.AvgArray());
	}

}

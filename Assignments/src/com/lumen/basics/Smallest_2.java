package com.lumen.basics;

public class Smallest_2 {
	int[] array;
	Smallest_2(int[] array){
		this.array=array;
	}
	void print() {
		for(int number:array) {
			System.out.print(number+" ");
		}
		System.out.println();
	}
	int greatest() {
		int min=2147483647;
		for(int number:array) {
			if(number<min)
				min=number;
		}
		return min;
	}
	public static void main(String[] args) {
		Smallest_2 intArray=new Smallest_2(new int[] {1,2,14,5});
		intArray.print();
		System.out.println("Smallest is: "+intArray.greatest());
	}

}

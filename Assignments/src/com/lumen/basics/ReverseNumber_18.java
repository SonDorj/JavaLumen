package com.lumen.basics;

public class ReverseNumber_18 {
	static void reverseNumber(long num) {
		long temp=num;
		System.out.println("Number : "+num);
		System.out.print("Reverse : ");
		while(temp>0) {
			System.out.print(temp%10);
			temp/=10;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		reverseNumber(12);
		reverseNumber(34123);
		reverseNumber(1231231231);
	}
}

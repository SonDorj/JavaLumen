package com.lumen.basics;

public class Factorial_7 {
	static int factorial(int number) {
		if(number==0)
			return 1;
		return number*factorial(number-1);
	}
	public static void main(String[] args) {
		int n=3;
		System.out.println(factorial(n));
	}
}

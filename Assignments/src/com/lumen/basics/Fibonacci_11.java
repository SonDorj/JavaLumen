package com.lumen.basics;

public class Fibonacci_11 {
	static void fibonacci(int first, int second,int n) {
		if(n==0) {
			System.out.println();
			return;
		}
		else {
			int third=first+second;
			System.out.print(first+" ");
			fibonacci(second,third,n-1);
		}
	}
	public static void main(String[] args) {
		fibonacci(0, 1, 12);
		fibonacci(0, 2, 3);
	}
}

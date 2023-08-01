package com.lumen.basics;

public class Pattern1_13 {
	static void pattern1(int n) {
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				System.out.print(i);
			}
			System.out.print(" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		pattern1(10);
	}
}

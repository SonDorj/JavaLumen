package com.lumen.basics;

public class Pyramid1_15 {
	static void pyramid1(int num) {
		for(int i=1;i<=num;i++) {
			for(int j=0;j<num-i;j++) {
				System.out.print(j);
			}
			for(int j=0;j<i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		pyramid1(5);
	}
}

package com.lumen.basics;

public class Pyramid2_16 {
	static void pyramid2(int num) {
		for(int i=num;i>0;i--) {
			for(int j=0;j<num-i;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		pyramid2(9);
	}
}

package com.lumen.basics;

public class Pattern2_14 {
	static void pattern2(int num) {
		int count=1;
		for(int i=1;count<num;i++) {
			for(int j=0; j<i;j++) {
				System.out.print(count++);
			}
			System.out.print("|");
		}
	}
	public static void main(String[] args) {
		pattern2(10);
	}
}

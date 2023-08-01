package com.lumen.scans;

import java.util.Scanner;

public class SqrtArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numbers[] = new int[10];
		for (int i = 0; i < 4; i++) {
			numbers[i] = scanner.nextInt();
		}
		double sqrtNumbers[]=new double[10];
		for(int i=0;i<4;i++) {
			sqrtNumbers[i]=Math.sqrt(numbers[i]);
		}
		for(int i=0;i<4;i++) {
			System.out.println(numbers[i]);
		}
		scanner.close();
	}
}

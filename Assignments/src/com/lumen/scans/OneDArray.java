package com.lumen.scans;

import java.util.Scanner;

public class OneDArray {
	int salaries[];

	void populate(int[] salaries) {
		this.salaries = salaries;
	}

	int sum() {
		int sum = 0;
		for (int salary : salaries) {
			sum += salary;
		}
		return sum;
	}

	double avg() {
		double avg = 0;
		avg = this.sum() / salaries.length;
		return avg;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int salaries[] = new int[10];
		for (int i = 0; i < 4; i++) {
			salaries[i] = scanner.nextInt();
		}

		OneDArray lumenSal = new OneDArray();
		lumenSal.populate(salaries);

		System.out.println(lumenSal.sum());
		System.out.println(lumenSal.avg());

		scanner.close();
	}
}

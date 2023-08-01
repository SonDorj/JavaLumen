package com.lumen.scans;

import java.util.Scanner;

public class Ternary {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		int c=scanner.nextInt();
		int max=(a>b&&b>c)?a:(b>c&&b>a)?b:c;
		System.out.println(max);
		scanner.close();
	}

}

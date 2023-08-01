package com.lumen.basics;

public class Armstrong_9 {
	static boolean armstrong(int num) {
		int sum=0;
		int temp=num;
		int digits=0;
		int last;
		while(temp>0) {
			temp/=10;
			digits++;
		}
		temp=num;
		while(temp>0) {
			last=temp%10;
			sum+=Math.pow(last, digits);
			temp/=10;
		}
		if(num==sum)
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(armstrong(12));
		System.out.println(armstrong(3));
		System.out.println(armstrong(1634));
	}
}

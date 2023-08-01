package com.lumen.basics;

public class Prime_12 {
	static boolean isPrime(int num) {
		if(num==1 || num==2)
			return true;
		else if(num<1)
			return false;
		else {
			for(int i=2;i*i<num;i++) {
				if(num%i==0)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPrime(-5));
		System.out.println(isPrime(1));
		System.out.println(isPrime(4));
		System.out.println(isPrime(9));
	}
}

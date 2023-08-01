package com.lumen.basics;

public class Perfect_10 {
	static boolean perfect(int num) {
		int sum=1;
		for(int i=2;i*i<=num;i++) {
			if(num%i==0)
				if(i*i!=num)
					sum+=i+num/i;
				else
					sum+=i;
		}
		if(sum==num&&num!=1)
			return true;
		return false;
	}
	public static void main(String[] args) {
		System.out.println(perfect(1));
		System.out.println(perfect(6));
		System.out.println(perfect(28));
		System.out.println(perfect(496));
		System.out.println(perfect(496));

	}

}

package com.lumen.scans;

public class Palindrome {
	static boolean isPalindrome(int number) {
		int temp=number;
		int reverse=0;
		while(temp>0) {
			int r=temp%10;
			reverse=(reverse*10)+r;
			temp/=10;
		}
		if(reverse==number) {
			return true;
		}

		return false;
	}
	public static void main(String[] args) {
		System.out.println(isPalindrome(71));
		System.out.println(isPalindrome(111));
	}
}

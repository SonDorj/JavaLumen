package com.lumen.scans;

public class Occurence {
	static int occurence(String word, char letter) {
		int count=0;
		for (int i = 0; i < word.length(); i++) {
			if(letter==word.charAt(i)) {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(occurence("Hello", 'l'));
	}
}

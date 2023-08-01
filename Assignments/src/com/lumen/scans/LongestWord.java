package com.lumen.scans;

public class LongestWord {
	String sentence;

	public LongestWord(String sentence) {
		this.sentence = sentence;
	}

	String longestWord() {
		String longestWord="";
		String[] words=sentence.split(" ");
		int max=0;
		for(String word: words) {
			if(word.length()>max){
				max=word.length();
				longestWord=word;
			}
		}
		return longestWord;
	}

	public static void main(String[] args) {
		LongestWord tongueTwistter=new LongestWord("Betty bought some butter. But she said the butter’s bitter. If I put it in my batter, it will make my batter bitter. But a bit of better butter will make my batter better. So ‘twas better Betty bought a bit of better butter.");
		tongueTwistter.longestWord();
	}
}

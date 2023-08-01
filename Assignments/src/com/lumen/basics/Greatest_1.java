package com.lumen.basics;

public class Greatest_1 {
		int[] array;
		Greatest_1(int[] array){
			this.array=array;
		}
		void print() {
			for(int number:array) {
				System.out.print(number+" ");
			}
			System.out.println();
		}
		int greatest() {
			int max=-2147483648;
			for(int number:array) {
				if(number>max)
					max=number;
			}
			return max;
		}
	public static void main(String[] args) {
		Greatest_1 intArray=new Greatest_1(new int[] {1,2,14,5});
		intArray.print();
		System.out.println("Greatest is: "+intArray.greatest());
	}

}

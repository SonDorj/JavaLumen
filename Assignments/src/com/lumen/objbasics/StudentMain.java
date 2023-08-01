package com.lumen.objbasics;

public class StudentMain {
	public static void main(String[] args) {
		Student student1 = new Student("Jane Doe","CSE",100,100,50);
		student1.printDetails();
		System.out.println(student1.getGrade());

		Student student2 = new Student("Blackacre","CSE",0,12,100,50);
		student2.printDetails();
		System.out.println(student2.getGrade());

	}
}

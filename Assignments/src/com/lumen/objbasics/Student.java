package com.lumen.objbasics;

public class Student {
	String name;
	String department;
	int marks[];
	char grade;
	public Student(String name, String department, int... marks) {
		super();
		this.name = name;
		this.department = department;
		this.marks = marks;
		calcGrade();
	}
	void printDetails() {
		System.out.println(name+" "+department+" "+marks.toString());
	}
	void calcGrade() {
		int sum=0;
		int avg=0;
		for(int mark: marks) {
			sum+=mark;
		}
		avg=sum/marks.length;
		switch(avg/10) {
		case(10):	grade='A';break;
		case(9):	grade='A';break;
		case(8):	grade='B';break;
		case(7):	grade='B';break;
		case(6):	grade='C';break;
		case(5):	grade='C';break;
		default:	grade='F';break;
		}
	}
	char getGrade() {
		return grade;
	}
}

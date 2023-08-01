package com.lumen.overloading;

import java.util.Scanner;

public class EmployeeMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Employees[] lumenEmployee = new Employees[3];
		for(int i=0;i<3;i++) {
			lumenEmployee[i]=new Employees(scanner.nextLine(),scanner.nextLine());
		}
		for(Employees employee: lumenEmployee) {
			switch(employee.Designation) {
			case "Manager": employee.printDetails(); System.out.println("Bonus : "+employee.calcBonus(40_000));break;
			case "Programmer":employee.printDetails(); System.out.println("Bonus : "+employee.calcBonus(40_000, 4_000));break;
			case "Director":employee.printDetails(); System.out.println("Bonus : "+employee.calcBonus(40_000, 4_000, 6_000));break;
			default: System.out.println("no Bonus");
			}
		}
		scanner.close();
	}
//	John
//	Manager
//	Doe
//	Programmer
//	jane
//	Director
}

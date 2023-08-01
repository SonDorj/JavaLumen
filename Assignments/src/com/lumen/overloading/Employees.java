package com.lumen.overloading;

public class Employees {
	String name;
	String Designation;
	public Employees() {
		
	}
	public Employees(String name, String designation) {
		this.name = name;
		Designation = designation;
	}

	public void printDetails() {
		System.out.println(name+" "+Designation);
	}
	
	public double calcBonus(double basicAllowance) {
		return (basicAllowance+basicAllowance*.1);
	}
	
	public double calcBonus(double basicAllowance,double travelAllowance) {
		return (calcBonus(basicAllowance)+travelAllowance);
	}
	
	public double calcBonus(double basicAllowance,double travelAllowance,double houseAllowance) {
		return (calcBonus(basicAllowance,travelAllowance)+houseAllowance);
	}
	
}

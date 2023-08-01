package com.lumen.objbasics;

public class BookMain {
	public static void main(String[] args) {
		Book textbook1=new Book("Head First Java","Kathy Siera","Education",900);
		Book novel1=new Book("Harry Potter and the Philosopher's Stone","J K Rowling","Novel",300);
		textbook1.getDetails();
		System.out.println("Category : "+textbook1.checkBookType());
		novel1.getDetails();
		System.out.println("Category : "+novel1.checkBookType());
	}
}

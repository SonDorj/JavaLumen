package com.lumen.objbasics;

public class Book {
	String title;
	String author;
	String category;
	double price;

	public Book(String title, String author, String category, double price) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
	}

	void getDetails() {
		System.out.println("Book Detail of :"+this.title);
		System.out.println("Authored by :"+this.author);
		System.out.println("Cost : $"+this.price);
		System.out.println("Is a : "+this.category);
	}

	String checkBookType() {
		if(this.price>500)
			return "Premium";
		else
			return "Standard";
	}

}
